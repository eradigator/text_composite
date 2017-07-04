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

    @Override
    public String toString() {
        String s = "";

        for (TextComponent textComposite : components) {
            s += textComposite;
        }

        return s;
    }
}
