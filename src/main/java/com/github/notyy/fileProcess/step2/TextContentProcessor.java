package com.github.notyy.fileProcess.step2;

import com.github.notyy.fileProcess.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class TextContentProcessor {
    private String[] titles;

    public TextContentProcessor() {
    }

    public TextContentProcessor(String[] titles){
        this.titles = titles;
    }

    public void addTitleAndCopyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        writeTitle(writer);
        CopyContent(reader, writer);
    }

    public void CopyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line = reader.readLine();
        while (line != null) {
            if(isValid(line)){
                writer.write(processLine(line));
            }
            line = reader.readLine();
        }
        writer.flush();
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