package com.javalab22.text.operation;

import com.javalab22.text.entity.impl.Symbol;
import com.javalab22.text.entity.impl.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by erad on 02.07.2017.
 */

public class Splitter {

    public static final String REGEX_PARAGRAPH = "(\\s*(.+))";
    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    public static final String REGEX_SYMBOL = "(\\r\\n)|.{1}";

    public Splitter() {
    }

    public TextComposite split(String inputText) {
        TextComposite text = new TextComposite();
        return parseToParagraph(text, inputText);
    }

    private TextComposite parseToParagraph(TextComposite wholeText, String text) {
        TextComposite paragraphList = new TextComposite();
        String paragraph;

        Matcher matcher = Pattern.compile(REGEX_PARAGRAPH).matcher(text);
        while (matcher.find()) {
            paragraph = matcher.group();
            paragraphList = parseToSentence(paragraphList, paragraph);
        }
        wholeText.add(paragraphList);
        return wholeText;
    }

    private TextComposite parseToSentence(TextComposite paragraphList, String paragraph) {

        TextComposite sentenceList = new TextComposite();
        String sentence;

        Pattern p = Pattern.compile(REGEX_SENTENCE);
        Matcher m = p.matcher(paragraph);

        while (m.find()) {
            sentence = m.group();
            sentenceList = parseToSignAndWord(sentenceList, sentence);
        }

        paragraphList.add(sentenceList);
        return paragraphList;
    }

    private TextComposite parseToSignAndWord(TextComposite wordList, String word) {
        TextComposite wordSignList = new TextComposite();
        Pattern p = Pattern.compile(REGEX_WORD_AND_SIGN);
        Matcher matcher = p.matcher(word);
        String wordSign;

        while (matcher.find()) {
            wordSign = matcher.group();
            wordSignList = parseToSymbol(wordSignList, wordSign);
        }
        wordList.add(wordSignList);
        return wordList;
    }

    private TextComposite parseToSymbol(TextComposite wordSignList, String wordSign) {

        Pattern p = Pattern.compile(REGEX_SYMBOL);
        String symbol;
        Matcher matcher = p.matcher(wordSign);
        Symbol symbolList;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolList = new Symbol(symbol);
            wordSignList.add(symbolList);
        }
        return wordSignList;
    }

}