package com.github.notyy.fileProcess.step3;


import java.io.*;

public class FileProcessor {
    private final TextContentProcessor textContentProcessor;

    public FileProcessor(TextContentProcessor textContentProcessor) {
        this.textContentProcessor = textContentProcessor;
    }

    public void addTitleAndOutput(String srcPath, String targetPath) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(srcPath));
            writer = new BufferedWriter(new FileWriter(targetPath));
            textContentProcessor.addTitleAndCopyContent(reader, writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
