package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.entity.TypeOfTextComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erad on 02.07.2017.
 * CompositePattern.Composite object
 */

public class TextComposite implements TextComponent {

    private TypeOfTextComponent typeOfTextComponent;

    private List<TextComponent> components = new ArrayList<TextComponent>();

    public TypeOfTextComponent getTypeOfTextComponent() {
        return typeOfTextComponent;
    }

    public void setTypeOfTextComponent(TypeOfTextComponent typeOfTextComponent) {
        this.typeOfTextComponent = typeOfTextComponent;
    }

    public void add(TextComponent textComposite) {
        components.add(textComposite);
    }

    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (TextComponent textComposite : components) {
            sb.append(textComposite);
        }

        return sb.toString();
    }
}
