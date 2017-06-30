package com.javalab22.text.runner;

import com.javalab22.text.entity.Text;
import com.javalab22.text.entity.Sentence;
import com.javalab22.text.entity.WordAndPunctuation;
import com.javalab22.text.operation.Print;
import com.javalab22.text.util.InputFromFile;
import com.javalab22.text.util.OutputToFile;

import java.io.FileInputStream;
import java.util.List;

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

        Print print = new Print();
        print.printArrayList(text.getText());

        List<String> sentences = (new Sentence()).split(text.getText());
        print.printArrayList(sentences);

        List<String> words = (new WordAndPunctuation().split(sentences));
        print.printArrayList(words);

        //in.readFile();

        //попробовать
        /*FileInputStream inFile = new FileInputStream("text.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);*/

    }
}

