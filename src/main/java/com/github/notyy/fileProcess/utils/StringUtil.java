package com.github.notyy.fileProcess.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static String[] splitIgnoreBracket(String str, String sep) {
        String[] rs = str.split(sep + "(?=[^\\]]*(?:\\[|$))",-1);
//        if (str.endsWith(sep)) {
//            List<String> list = new ArrayList<String>();
//            list.addAll(Arrays.asList(rs));
//            list.add("");
//            return list.toArray(new String[list.size()]);
//        }
        return rs;
    }
}
