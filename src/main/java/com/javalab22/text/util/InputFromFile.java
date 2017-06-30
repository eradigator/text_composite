package com.javalab22.text.util;

import com.javalab22.text.entity.Text;

import java.io.*;

/**
 * Created by erad on 28.06.2017.
 */
public class InputFromFile {

    private String inputFileName = "text.txt";

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
    }

    public void readFile() {
        try {

            InputStream fileInputStream = new FileInputStream(inputFileName);

            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

}
