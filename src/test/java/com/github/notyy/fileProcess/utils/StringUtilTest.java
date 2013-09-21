package com.github.notyy.fileProcess.utils;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilTest {
    @Test
    public void split_should_ignoreBracket() throws Exception {
        assertThat(StringUtil.splitIgnoreBracket("abc,[xyz,zzz],ddd",",").length, is(3));
        assertThat(StringUtil.splitIgnoreBracket("abc,ddd",",").length, is(2));
    }

    @Test
    public void should_add_space_if_end_with_sep() {
        assertThat(StringUtil.splitIgnoreBracket("aa,bb",",").length, is(2));
        assertThat(StringUtil.splitIgnoreBracket("aa,bb,",",").length, is(3));
    }
}
