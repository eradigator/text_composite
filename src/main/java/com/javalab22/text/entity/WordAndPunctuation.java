package com.javalab22.text.entity;

import com.javalab22.text.operation.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vten on 30.06.2017.
 */
public class WordAndPunctuation implements Splitter {

    public List<String> split(List<String> list) {

        List<String> words = new ArrayList<String>();
        Pattern p = Pattern.compile("\\s*(\\s|\\@\\#)\\s*");

        for (String s : list) {
            s = s.replace(",", "@#,@#");
            s = s.replace(".", "@#.@#");
            s = s.replace("!", "@#!@#");
            s = s.replace("?", "@#?@#");
            s = s.replace(":", "@#:@#");
            s = s.replace(";", "@#;@#");

            for (String s1 : p.split(s)) {
                words.add(s1);
            }
        }

        return words;
    }
}
