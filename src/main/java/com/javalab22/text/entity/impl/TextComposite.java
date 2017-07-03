package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erad on 02.07.2017.
 * Composite object
 */

public class TextComposite implements TextComponent {

    private List<TextComponent> components = new ArrayList<TextComponent>();

    public void add(TextComponent textComponent) {
        components.add(textComponent);
    }

    public TextComponent get(int index) {
        return components.get(index);
    }

    public void print() {
        for (TextComponent textComponent : components) {
            //тут надо что-то придумать
            textComponent.print();
        }
    }
}
