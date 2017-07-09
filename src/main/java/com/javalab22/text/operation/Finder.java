package com.javalab22.text.operation;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.entity.TypeOfTextComponent;
import com.javalab22.text.entity.impl.Symbol;
import com.javalab22.text.entity.impl.TextComposite;

import java.util.List;

/**
 * Created by erad on 07.07.2017.
 * В тексте определить все согласные буквы, встречающиеся не более чем в двух словах
 */

public class Finder {

    public List<Symbol> findConsonant(TextComponent tc) {

        String s = "ш";


        for (int i = 0; i < ((TextComposite) tc).getComponents().size(); i++) {

            if (((TextComposite) tc).getTypeOfTextComponent() != TypeOfTextComponent.WORD) {
                //System.out.println(((TextComposite) tc).getTypeOfTextComponent());
                findConsonant(((TextComposite) tc).getComponents().get(i));
            } else {
                //System.out.println(((TextComposite) tc).getComponents().get(i).toString());
                if (((TextComposite) tc).getComponents().get(i).toString().contains(s)) {
                    System.out.println("Найдена буква ш");
                }
            }

        }

        return null;
    }
}
