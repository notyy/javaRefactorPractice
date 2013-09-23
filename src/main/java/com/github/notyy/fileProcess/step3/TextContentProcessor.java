package com.github.notyy.fileProcess.step3;

import com.github.notyy.fileProcess.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class TextContentProcessor {
    private String[] titles;
    private final int[] keyColumnIndexs;
    private LinkedHashMap<String, String> keyLineMap = new LinkedHashMap<String, String>();

    public TextContentProcessor(String[] titles) {
        this(titles, null);
    }

    public TextContentProcessor(String[] titles, int[] keyColumnIndexs) {
        this.titles = titles;
        this.keyColumnIndexs = keyColumnIndexs;
    }

    public void addTitleAndCopyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        writeTitle(writer);
        CopyContent(reader, writer);
    }

    public void CopyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        if (needCheckKey()) {
            List<String> lines = readLines(reader);
            preProcess(lines);
            for (String line : keyLineMap.values()) {
                writer.write(processLine(line));
            }
        } else {
            String line = reader.readLine();
            while (line != null) {
                if (isValid(line)) {
                    writer.write(processLine(line));
                }
                line = reader.readLine();
            }
        }
        writer.flush();
    }

    private void preProcess(List<String> lines) {
        for (String line : lines) {
            if (isValid(line)) {
                String[] values = StringUtil.splitIgnoreBracket(line, ",");
                String key = "";
                for (int keyColumnIndex : keyColumnIndexs) {
                    key += values[keyColumnIndex] + ",";
                }
                if (keyLineMap.containsKey(key)) {
                    keyLineMap.put(key, mergeLine(keyLineMap.get(key), line));
                } else {
                    keyLineMap.put(key, line);
                }
            }
        }
    }

    private boolean needCheckKey() {
        return keyColumnIndexs != null && keyColumnIndexs.length > 0;
    }

    public static String mergeLine(String line1, String line2) {
        String[] values1 = StringUtil.splitIgnoreBracket(line1, ",");
        String[] values2 = StringUtil.splitIgnoreBracket(line2, ",");
        for (int i = 0; i < values1.length; i++) {
            String value1 = values1[i];
            String value2 = values2[i];
            if (!value1.equals(value2)) {
                if (StringUtils.isEmpty(value1)) {
                    values1[i] = value2;
                } else if(StringUtils.isEmpty(value2)){

                }else {
                    if (value2.startsWith("[")) {
                        value2 = value2.substring(1, value2.indexOf("]"));
                    }
                    if (value1.startsWith("[")) {
                        values1[i] = value1.substring(0, value1.indexOf("]")) + "," + value2 + "]";
                    } else {
                        values1[i] = "[" + value1 + "," + value2 + "]";
                    }
                }
            }
        }
        return StringUtils.join(values1, ",");
    }

    private List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            if (isValid(line)) {
                lines.add(line);
            }
            line = reader.readLine();
        }
        return lines;
    }

    public boolean isValid(String line) {
        return StringUtil.splitIgnoreBracket(line, ",").length == titles.length;
    }

    private String processLine(String line) {
        return line + "\n";
    }

    public void writeTitle(BufferedWriter writer) throws IOException {
        writer.write(titleLine());
    }

    public String titleLine() {
        return StringUtils.join(titles, ",") + "\n";
    }
}