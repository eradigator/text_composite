package com.javalab22.text.util;

import com.javalab22.text.entity.Text;

import java.io.*;

/**
 * Created by erad on 28.06.2017.
 */
public class InputFromFile {
    public void inputFromFile(Text text) {
        try {
            InputStream fileInputStream = new FileInputStream("text.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "cp1251"));

            String s;
            while ((s = br.readLine()) != null) {
                text.getText().add(s);
            }
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    };
}
