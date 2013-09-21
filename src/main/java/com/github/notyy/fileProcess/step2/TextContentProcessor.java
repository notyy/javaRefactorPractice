package com.github.notyy.fileProcess.step2;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class TextContentProcessor {
    public TextContentProcessor() {
    }

    public void addTitleAndCopyContent(String[] titles, BufferedReader reader, BufferedWriter writer) throws IOException {
        writeTitle(titles, writer);
        CopyContent(reader, writer);
    }

    public void CopyContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line = reader.readLine();
        while (line != null) {
            writer.write(line + "\n");
            line = reader.readLine();
        }
        writer.flush();
    }

    public void writeTitle(String[] titles, BufferedWriter writer) throws IOException {
        String title = StringUtils.join(titles, ",");
        writer.write(title + "\n");
    }
}