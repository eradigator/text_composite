package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;

/**
 * Created by erad on 02.07.2017.
 * CompositePattern.Leaf
 */


public class Symbol implements TextComponent {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
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

