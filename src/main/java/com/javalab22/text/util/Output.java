package com.javalab22.text.util;

import java.io.*;

/**
 * Created by erad on 28.06.2017.
 */
public class Output {

    public void writeFile(String text,String outputFileName) {

        try {
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8"));

            out.append(text);
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
