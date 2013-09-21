package com.github.notyy.fileProcess.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public FileReaderUtil() {
    }

    public static List<String> readLines(String targetPath) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(targetPath));
            List<String> rs = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                rs.add(line);
                line = reader.readLine();
            }
            return rs;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}