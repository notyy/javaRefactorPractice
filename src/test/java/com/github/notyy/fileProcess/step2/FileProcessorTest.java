package com.github.notyy.fileProcess.step2;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileProcessorTest {

    public static final String SRC_PATH = "src/test/resource/sample1.csv";
    public static final String TARGET_PATH = "src/test/resource/sample1_title.csv";
    public static final String[] TITLES = new String[]{"中文名", "昵称", "英文名", "性别", "出生年份", "逝世年份", "身高", "体重", "星座"};

    @Test
    public void file_processor_will_add_title_to_result_file() throws IOException {
        BufferedReader reader = null;
            FileProcessor fileProcessor = new FileProcessor();
            fileProcessor.addTitleAndOutput(
                    SRC_PATH,
                    TARGET_PATH,
                    TITLES);
        try{
            reader = new BufferedReader(new FileReader(TARGET_PATH));
            List<String> lines = readLines(reader);
            assertThat(lines.size(), is(11));

            String firstLine = lines.get(0);
            assertThat(firstLine, is(StringUtils.join(TITLES,",")));

            String firstFieldOfLastLine = lines.get(10).split(",")[0];
            assertThat(firstFieldOfLastLine, is("王菲"));
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private List<String> readLines(BufferedReader reader) throws IOException {
        List<String> rs = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null){
            rs.add(line);
            line = reader.readLine();
        }
        return rs;
    }
}
