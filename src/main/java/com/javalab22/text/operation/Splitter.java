package com.javalab22.text.operation;

import com.javalab22.text.entity.TypeOfTextComponent;
import com.javalab22.text.entity.impl.Symbol;
import com.javalab22.text.entity.impl.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by erad on 02.07.2017.
 * Разобрать исходный текст на составляющие (параграф, предложение, слово, символ)
 * Собрать заново из составляющих, и вывести.
 * Исходный текст и результат должны быть идентичны
 */

public class Splitter {

    public static final String REGEX_PARAGRAPH = "(\\s*(.+))";
    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_WORD_AND_PUNCTUATION = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    public static final String REGEX_SYMBOL = "\\r|\\n|.{1}";


    public Splitter() {
    }

    public TextComposite split(String inputText) {
        TextComposite text = new TextComposite();
        return splitToParagraphs(text, inputText);
    }

    private TextComposite splitToParagraphs(TextComposite wholeText, String text) {

        TextComposite paragraphList = new TextComposite();
        String paragraph;
        Matcher m = Pattern.compile(REGEX_PARAGRAPH).matcher(text);

        while (m.find()) {
            paragraph = m.group();
            paragraphList = splitToSentences(paragraphList, paragraph);
        }

        wholeText.add(paragraphList);
        wholeText.setTypeOfTextComponent(TypeOfTextComponent.TEXT);
        return wholeText;
    }

    private TextComposite splitToSentences(TextComposite paragraphList, String paragraph) {

        TextComposite sentenceList = new TextComposite();
        String sentence;
        Matcher m = Pattern.compile(REGEX_SENTENCE).matcher(paragraph);

        while (m.find()) {
            sentence = m.group();
            sentenceList = splitToWord(sentenceList, sentence);
        }

        paragraphList.add(sentenceList);
        paragraphList.setTypeOfTextComponent(TypeOfTextComponent.PARAGRAPH);
        return paragraphList;
    }

    private TextComposite splitToWord(TextComposite sentenceList, String sentence) {

        TextComposite wordList = new TextComposite();
        String word;
        Matcher matcher = Pattern.compile(REGEX_WORD).matcher(sentence);

        while (matcher.find()) {
            word = matcher.group();
            wordList = splitToWordAndPunctuation(wordList, word);
        }

        sentenceList.add(wordList);
        sentenceList.setTypeOfTextComponent(TypeOfTextComponent.SENTENCE);
        return sentenceList;
    }

    private TextComposite splitToWordAndPunctuation(TextComposite wordList, String word) {

        TextComposite wordSignList = new TextComposite();
        String wordSign;
        Matcher matcher = Pattern.compile(REGEX_WORD_AND_PUNCTUATION).matcher(word);

        while (matcher.find()) {
            wordSign = matcher.group();
            wordSignList = splitToSymbols(wordSignList, wordSign);
        }

        wordList.add(wordSignList);
        wordList.setTypeOfTextComponent(TypeOfTextComponent.WORD);
        return wordList;
    }

    private TextComposite splitToSymbols(TextComposite symbolList, String wordSign) {

        Symbol symbol;
        String symbolFromMatcher;
        Matcher matcher = Pattern.compile(REGEX_SYMBOL).matcher(wordSign);

        while (matcher.find()) {
            symbolFromMatcher = matcher.group();
            symbol = new Symbol(symbolFromMatcher.charAt(0));
            symbolList.add(symbol);
        }

        symbolList.setTypeOfTextComponent(TypeOfTextComponent.SYMBOL);
        return symbolList;
    }

}