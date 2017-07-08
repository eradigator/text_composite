package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.entity.TypeOfTextComponent;

/**
 * Created by erad on 02.07.2017.
 * CompositePattern.Leaf
 */


public class Symbol implements TextComponent {

    private String symbol;

    private TypeOfTextComponent typeOfTextComponent;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public TypeOfTextComponent getTypeOfTextComponent() {
        return typeOfTextComponent;
    }

    public void setTypeOfTextComponent(TypeOfTextComponent typeOfTextComponent) {
        this.typeOfTextComponent = typeOfTextComponent;
    }

    public void add(TextComponent textComposite) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString()
    {
        return symbol;
    }
}

