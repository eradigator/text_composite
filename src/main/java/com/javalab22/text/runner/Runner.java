package com.javalab22.text.runner;

import com.javalab22.text.entity.Paragraph;
import com.javalab22.text.entity.Text;
import com.javalab22.text.entity.Sentence;
import com.javalab22.text.entity.WordAndPunctuation;
import com.javalab22.text.operation.Print;
import com.javalab22.text.util.InputFromFile;
import com.javalab22.text.util.OutputToFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Разобрать исходный текст на составляющие (параграф, предложение, слово, символ)
 * Собрать заново из составляющих, и вывести.
 * Исходный текст и результат должны быть идентичны
 */

public class Runner {
    public static void main(String[] args) {

        Text text = new Text();
        text.addText(new InputFromFile().readFile("text.txt"));

        Print print = new Print();
        print.printArrayList(text.getText());

        List<String> paragraphs = new Paragraph().split(text.getText());
        print.printArrayList(paragraphs);

        List<String> sentences = (new Sentence()).split(paragraphs);
        print.printArrayList(sentences);

        List<String> words = (new WordAndPunctuation().split(sentences));
        print.printArrayList(words);

        OutputToFile out = new OutputToFile();
        out.outputToFile(text);

    }
}

