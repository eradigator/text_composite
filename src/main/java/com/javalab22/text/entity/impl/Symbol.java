package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;

/**
 * Created by erad on 02.07.2017.
 * CompositePattern.Leaf
 */


public class Symbol implements TextComponent {

    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public void add(TextComponent textComposite) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString()
    {
        //return String.valueOf(symbol);
        return symbol;
    }
}

