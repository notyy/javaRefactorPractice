package com.github.notyy.fileProcess.step1;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class TextContentProcessor {
    public TextContentProcessor() {
    }

    void processContent(String[] titles, BufferedReader reader, BufferedWriter writer) throws IOException {
        writeTitle(titles, writer);
        writeContent(reader, writer);
        writer.flush();
    }

    private void writeContent(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line = reader.readLine();
        while (line != null) {
            if (isValid(line)) {
                writer.write(line + "\n");
            }
            line = reader.readLine();
        }
    }

    private boolean isValid(String line) {
        return true;
    }

    private void writeTitle(String[] titles, BufferedWriter writer) throws IOException {
        String title = StringUtils.join(titles, ",");
        writer.write(title + "\n");
    }
}