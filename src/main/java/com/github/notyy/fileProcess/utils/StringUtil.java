package com.github.notyy.fileProcess.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static String[] splitIgnoreBracket(String str, String sep) {
        String[] rs = str.split(sep + "(?=[^\\]]*(?:\\[|$))",-1);
        return rs;
    }
}
