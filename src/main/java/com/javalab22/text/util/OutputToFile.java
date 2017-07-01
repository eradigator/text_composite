package com.javalab22.text.util;

import com.javalab22.text.entity.Text;

import java.io.*;

/**
 * Created by erad on 28.06.2017.
 */
public class OutputToFile {

    public void outputToFile(Text text) {

        try {
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt"), "cp1251"));

            for (String s : text.getText()) {
                out.append(s);
            }

            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
