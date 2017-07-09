package com.javalab22.text.runner;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.operation.Finder;
import com.javalab22.text.operation.Splitter;
import com.javalab22.text.util.Input;
import com.javalab22.text.util.Output;

/**
 * Created by erad on 28.06.2017.
 */


public class Runner {

    public static final String INPUT_FILE_NAME = "textUTF8.txt";
    public static final String OUTPUT_FILE_NAME = "result.txt";

    public static void main(String[] args) {

        String s = new Input().readFile(INPUT_FILE_NAME);

        TextComponent wholeText = new Splitter().split(s);

        System.out.println(wholeText.toString());

        new Output().writeFile(wholeText.toString(), OUTPUT_FILE_NAME);

        System.out.println(new Finder().findConsonant(wholeText));

    }
}

