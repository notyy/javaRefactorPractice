package com.github.notyy.fileProcess.step2;

import com.github.notyy.fileProcess.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextContentProcessor {
    private String[] titles;
    private final int[] keyColumnIndexs;

    public TextContentProcessor(String[] titles) {
        this(titles, null);
    }

    public TextContentProcessor(String[] titles, int[] keyColumnIndexs) {
        this.titles = titles;
        this.keyColumnIndexs = keyColumnIndexs;
    }

    public void addTitleAndCopyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        writeTitle(writer);
        copyContent(reader, writer);
    }

    public void copyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        if (keyColumnIndexs == null || keyColumnIndexs.length == 0) {
            String line = reader.readLine();
            while (line != null) {
                if (isValid(line)) {
                    writer.write(processLine(line));
                }
                line = reader.readLine();
            }
            writer.flush();
        }else{
            Map<String, String> keyLineMap = new LinkedHashMap<String, String>();
            String line = reader.readLine();
            while (line != null) {
                if (isValid(line)) {
                    String[] values = StringUtil.splitIgnoreBracket(line,",");
                    StringBuilder key = new StringBuilder();
                    for(int keyColumn: keyColumnIndexs){
                        key.append(values[keyColumn] + ",");
                    }
                    if(keyLineMap.containsKey(key.toString())){
                        keyLineMap.put(key.toString(),merge(keyLineMap.get(key.toString()), line));
                    }
                }
                line = reader.readLine();
            }
            writer.write(processLine(line));
            writer.flush();
        }
    }

    private String merge(String line1, String line2) {
        return line1;  //To change body of created methods use File | Settings | File Templates.
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