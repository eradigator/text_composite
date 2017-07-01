package com.javalab22.text.entity;

import com.javalab22.text.operation.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vten on 30.06.2017.
 */
public class Paragraph implements Splitter {


    public List<String> split(List<String> list) {

        List<String> paragraphs = new ArrayList<String>();

        Pattern p = Pattern.compile(System.getProperty("line.separator"));

        for (String s : list) {
            for (String s1 : p.split(s)) {
                paragraphs.add(s1);
            }
        }

        return paragraphs;
    }
}

