package com.github.notyy.fileProcess.step1;


import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class FileProcessor {
    public void addTitleAndOutput(String srcPath, String targetPath, String[] titles) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(srcPath));
            writer = new BufferedWriter(new FileWriter(targetPath));
            String title = StringUtils.join(titles, ",");
            writer.write(title + "\n");
            String line = reader.readLine();
            while (line != null) {
                writer.write(line + "\n");
                line = reader.readLine();
            }
            writer.flush();
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
