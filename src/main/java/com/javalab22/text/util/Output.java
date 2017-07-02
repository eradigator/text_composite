package com.javalab22.text.util;

import com.javalab22.text.entity.TextComponent;

import java.io.*;

/**
 * Created by erad on 28.06.2017.
 */
public class Output {

    public void writeFile(TextComponent text) {

        try {
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt"), "cp1251"));

            out.append(text.toString());
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
