package com.github.notyy.fileProcess.step3;

import com.github.notyy.fileProcess.utils.FileReaderUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileProcessorTest {

    public static final String SRC_PATH = "src/test/resource/sample1.csv";
    public static final String TARGET_PATH = "src/test/resource/sample1_title.csv";
    public static final String[] TITLES = new String[]{"中文名", "昵称", "英文名", "性别", "出生年份", "逝世年份", "身高", "体重", "星座"};

    @Test
    public void file_processor_will_add_title_to_result_file() throws IOException {
        FileProcessor fileProcessor = new FileProcessor(new TextContentProcessor(TITLES));
        fileProcessor.addTitleAndOutput(
                SRC_PATH,
                TARGET_PATH
        );
        List<String> lines = FileReaderUtil.readLines(TARGET_PATH);
        assertThat(lines.size(), is(10));

        String firstLine = lines.get(0);
        assertThat(firstLine, is(StringUtils.join(TITLES, ",")));

        String firstFieldOfLastLine = lines.get(9).split(",")[0];
        assertThat(firstFieldOfLastLine, is("王菲"));
    }
}
