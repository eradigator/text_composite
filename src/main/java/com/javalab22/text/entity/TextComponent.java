package com.javalab22.text.entity;

/**
 * Created by erad on 01.07.2017.
 *
 * Composite.Interface
 */


public interface TextComponent {

    void add(TextComponent textComponent);
    TextComponent get(int index);
    void print();

}
