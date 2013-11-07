package com.github.notyy.fileProcess.step3;

import com.github.notyy.fileProcess.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TextContentProcessorTest {
    @Mock
    private BufferedReader reader;
    @Mock
    private BufferedWriter writer;

    private TextContentProcessor contentProcessor;

    @Test
    public void title_line_is_String_separated_by_comma(){
        contentProcessor = new TextContentProcessor(new String[] {"lineNo","content"});
        assertThat(contentProcessor.titleLine(), is("lineNo,content\n"));
    }

    @Test
    public void should_write_title_then_copy_content() throws IOException {
        when(reader.readLine()).thenReturn("1,abc","2,xyz",null);
        InOrder inOrder = inOrder(writer);
        contentProcessor = new TextContentProcessor(new String[] {"lineNo","content"});
        contentProcessor.addTitleAndCopyContent(reader, writer);
        inOrder.verify(writer).write(contentProcessor.titleLine());
        inOrder.verify(writer).write("1,abc\n");
        inOrder.verify(writer).write("2,xyz\n");
    }

    @Test
    public void should_ignore_line_if_invalid() throws IOException {
        when(reader.readLine()).thenReturn("1,abc","2",null);
        InOrder inOrder = inOrder(writer);
        contentProcessor = new TextContentProcessor(new String[] {"lineNo","content"});
        contentProcessor.addTitleAndCopyContent(reader, writer);
        inOrder.verify(writer).write(contentProcessor.titleLine());
        inOrder.verify(writer).write("1,abc\n");
        inOrder.verify(writer,never()).write("2\n");
    }

    @Test
    public void should_merge_Content_if_two_lines_belongs_to_same_people() throws IOException {
        when(reader.readLine()).thenReturn(
                "陈奕迅,[阿臣,医生],Eason Chan,男,1974,,,85,狮子座",
                "陈奕迅,[E神,E臣],,男,1974,,171,,狮子座",null);
        InOrder inOrder = inOrder(writer);
        String[] TITLES = new String[]{"中文名", "昵称", "英文名", "性别", "出生年份", "逝世年份", "身高", "体重", "星座"};
        contentProcessor = new TextContentProcessor(TITLES, new int[]{0,3,4});
        contentProcessor.addTitleAndCopyContent(reader, writer);
        inOrder.verify(writer).write(contentProcessor.titleLine());
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        inOrder.verify(writer).write(arg.capture());
        assertThat(arg.getValue(),is("陈奕迅,[阿臣,医生,E神,E臣],Eason Chan,男,1974,,171,85,狮子座\n"));
        inOrder.verify(writer,never()).write(anyString());
    }

    @Test
    public void test_merge_line(){
        assertThat(TextContentProcessor.mergeLine("1,zz,abc","1,zz,def"),is("1,zz,[abc,def]"));
        assertThat(TextContentProcessor.mergeLine("1,zz,[abc,xyz]","1,zz,def"),is("1,zz,[abc,xyz,def]"));
        assertThat(TextContentProcessor.mergeLine("1,zz,[abc,xyz]","1,zz,[def,gef]"),is("1,zz,[abc,xyz,def,gef]"));
        assertThat(TextContentProcessor.mergeLine("1,zz,abc","1,zz,[def,gef]"),is("1,zz,[abc,def,gef]"));
        assertThat(TextContentProcessor.mergeLine("1,zz,abc","1,,def"),is("1,zz,[abc,def]"));
        assertThat(TextContentProcessor.mergeLine("1,zz,[abc,xyz]","1,zz,[abc,gef]"),is("1,zz,[abc,xyz,gef]"));
    }



    @Test
    public void must_valid_line(){
        String[] TITLES = new String[]{"中文名", "昵称", "英文名", "性别", "出生年份", "逝世年份", "身高", "体重", "星座"};
        String line = "张国荣,[十仔,哥哥,荣少,张发宗,阿仔],Leslie Cheung,男,1956,2003,175,70,处女座";
        String mick = "迈克杰克逊,,Michael Jackson,男,,,,,";
        System.out.println("lineLength:"+ StringUtil.splitIgnoreBracket(mick, ",").length);
        System.out.println("titleLength:"+TITLES.length);
        contentProcessor = new TextContentProcessor(TITLES);
        assertThat(contentProcessor.isValid(line), is(true));
        assertThat(contentProcessor.isValid(mick), is(true));
    }

}
