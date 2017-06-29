package com.javalab22.text.runner;

import com.javalab22.text.entity.Text;
import com.javalab22.text.entity.Sentence;
import com.javalab22.text.util.InputFromFile;
import com.javalab22.text.util.OutputToFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Разобрать исходный текст на составляющие (параграф, предложение, слово, символ)
 * Собрать заново из составляющих, и вывести.
 * Исходный текст и результат должны быть идентичны
 */
public class Runner {
    public static void main(String[] args) {

        Text text = new Text();

        InputFromFile in = new InputFromFile();
        in.inputFromFile(text);

        OutputToFile out = new OutputToFile();
        out.outputToFile(text);

        /*System.out.println("Весь текст: ");
        for (String s : text.getText()) {
            System.out.println(s);
        }*/

        //Разбиение на строки
        Sentence sentence = new Sentence();
        List<String> list = sentence.sentenceSplit(text);

        /*for (String s : list) {
            System.out.println(s);
        }*/

        List<String> words = new ArrayList<String>();
        Pattern p = Pattern.compile("\\s");

        for (String s : list) {
            for (String s1 : p.split(s)) {
                words.add(s1);
            }
        }

        for (String s : words) {
            System.out.println(s);
        }
    }
}

