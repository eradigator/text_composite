package com.javalab22.text.operation;

import com.javalab22.text.entity.TextComponent;
import com.javalab22.text.entity.TypeOfTextComponent;
import com.javalab22.text.entity.impl.TextComposite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by erad on 07.07.2017.
 * В тексте определить все согласные буквы, встречающиеся не более чем в двух словах
 */

public class Finder {

    public static final String REGEX_CONSONANT = "[бвгдзжйклмнпрстфхцчшщ]";
    public static final Integer COUNT_OF_OCCURRENCES = 10;


    public String findConsonant(TextComponent tc) {

        Pattern p = Pattern.compile(REGEX_CONSONANT);
        StringBuilder listOfConsonants = new StringBuilder();
        Map<Character, Integer> mapOfConsonants = new HashMap<Character, Integer>();
        List<String> result = new ArrayList<String>();

        //получаем список всех согласных
        for (int i = 0; i < ((TextComposite) tc).getComponents().size(); i++) {

            if (((TextComposite) tc).getTypeOfTextComponent() != TypeOfTextComponent.TEXT) {
                findConsonant(((TextComposite) tc).getComponents().get(i));
            } else {
                Matcher m = p.matcher(((TextComposite) tc).getComponents().get(i).toString().toLowerCase());
                while (m.find()) {
                    listOfConsonants.append(m.group());
                }
            }
        }

        //находим количество одинаковых элементов
        for (Character ch : listOfConsonants.toString().toCharArray()) {
            if (mapOfConsonants.containsKey(ch)) {
                mapOfConsonants.put(ch, mapOfConsonants.get(ch) + 1);
            } else {
                mapOfConsonants.put(ch, 1);
            }
        }

        //записываем в результат
        for (Map.Entry<Character, Integer> map : mapOfConsonants.entrySet()) {
            if (map.getValue() <= COUNT_OF_OCCURRENCES) {
                result.add(map.toString());
            }
        }

        return result.toString();

    }
}
