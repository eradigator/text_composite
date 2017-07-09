package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.entity.TypeOfTextComponent;

/**
 * Created by erad on 02.07.2017.
 * CompositePattern.Leaf
 */


public class Symbol implements TextComponent {

    private char symbol;

    private TypeOfTextComponent typeOfTextComponent;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
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
        return String.valueOf(symbol);
    }
}

