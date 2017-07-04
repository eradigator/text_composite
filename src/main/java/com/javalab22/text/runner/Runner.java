package com.javalab22.text.runner;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.operation.Splitter;
import com.javalab22.text.util.Input;
import com.javalab22.text.util.Output;

/**
 * Разобрать исходный текст на составляющие (параграф, предложение, слово, символ)
 * Собрать заново из составляющих, и вывести.
 * Исходный текст и результат должны быть идентичны
 * <p>
 * Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
 */

public class Runner {
    public static void main(String[] args) {

        String s = new Input().readFile("text.txt");

        Splitter splitter = new Splitter();
        TextComponent wholeText = splitter.split(s);

        System.out.println(wholeText.toString());
        new Output().writeFile(wholeText.toString());

    }
}

