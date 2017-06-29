package com.javalab22.text.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erad on 26.06.2017.
 */
public class Text {

    private List<String> text = new ArrayList<String>();

    public String getElement(int i) {
        return text.get(i);
    }

    public int getSize() {
        return text.size();
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
