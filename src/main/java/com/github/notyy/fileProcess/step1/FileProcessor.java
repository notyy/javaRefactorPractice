package com.github.notyy.fileProcess.step1;


import java.io.*;

public class FileProcessor {
    private final TextContentProcessor textContentProcessor = new TextContentProcessor();

    public void addTitleAndOutput(String srcPath, String targetPath, String[] titles) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(srcPath));
            writer = new BufferedWriter(new FileWriter(targetPath));
            textContentProcessor.processContent(titles, reader, writer);
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
