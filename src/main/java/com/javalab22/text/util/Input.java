package com.javalab22.text.util;

import java.io.*;

/**
 * Created by erad on 28.06.2017.
 */
public class Input {

    public String readFile(String fileName) {

        try {

            InputStream fileInputStream = new FileInputStream(fileName);
            byte[] fileBytesArray = new byte[fileInputStream.available()];
            fileInputStream.read(fileBytesArray);
            return new String(fileBytesArray, "cp1251");

        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }
}
