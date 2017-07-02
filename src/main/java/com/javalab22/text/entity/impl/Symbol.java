package com.javalab22.text.entity.impl;

import com.javalab22.text.entity.TextComponent;

/**
 * Created by erad on 02.07.2017.
 * Leaf
 */


public class Symbol implements TextComponent {

    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    public TextComponent get(int index) {
        return this;
    }

    public void print() {
        System.out.print(symbol);
    }
}
