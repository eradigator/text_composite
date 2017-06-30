package com.javalab22.text.entity;


import com.javalab22.text.operation.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by erad on 28.06.2017.
 */
public class Sentence implements Splitter{

    public List<String> split(List<String> list) {

        List<String> sentences = new ArrayList<String>();
        Pattern p = Pattern.compile("([А-ЯA-Z]((т.п.|т.д.|пр.|т.е.|т.о.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");

        for (String s : list) {
            Matcher matcher = p.matcher(s);
            while (matcher.find()) {
                sentences.add(matcher.group());
            }
        }

        return sentences;
    }


}
