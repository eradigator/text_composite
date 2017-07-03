package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erad on 02.07.2017.
 * CompositePattern.Composite object
 */

public class TextComposite implements TextComponent {

    private List<TextComponent> components = new ArrayList<TextComponent>();

    public void add(TextComponent textComposite) {
        components.add(textComposite);
    }

    public void remove(TextComponent textComposite) {
        components.remove(textComposite);
    }

    public List<TextComponent> get() {
        return components;
    }

    @Override
    public String toString() {
        String s = "";
        //StringBuilder stringBuilder = new StringBuilder();

        for (TextComponent textComposite : components) {
            s += textComposite;
            //stringBuilder.append(textComposite);
        }

        return s;
        //return stringBuilder.toString();
    }
}
