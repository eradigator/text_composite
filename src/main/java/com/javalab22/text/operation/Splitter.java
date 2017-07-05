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
        return splitToParagraphs(text, inputText);
    }

    private TextComposite splitToParagraphs(TextComposite wholeText, String text) {
        TextComposite paragraphList = new TextComposite();
        String paragraph;
        Matcher matcher = Pattern.compile(REGEX_PARAGRAPH).matcher(text);

        while (matcher.find()) {
            paragraph = matcher.group();
            paragraphList = splitToSentences(paragraphList, paragraph);
        }

        wholeText.add(paragraphList);
        return wholeText;
    }

    private TextComposite splitToSentences(TextComposite paragraphList, String paragraph) {

        TextComposite sentenceList = new TextComposite();
        String sentence;
        Matcher m = Pattern.compile(REGEX_SENTENCE).matcher(paragraph);

        while (m.find()) {
            sentence = m.group();
            sentenceList = splitToWords(sentenceList, sentence);
        }

        paragraphList.add(sentenceList);
        return paragraphList;
    }

    private TextComposite splitToWords(TextComposite wordList, String word) {

        TextComposite symbolList = new TextComposite();
        String wordSign;
        Matcher matcher = Pattern.compile(REGEX_WORD_AND_SIGN).matcher(word);

        while (matcher.find()) {
            wordSign = matcher.group();
            symbolList = splitToSymbols(symbolList, wordSign);
        }

        wordList.add(symbolList);
        return wordList;
    }

    private TextComposite splitToSymbols(TextComposite symbolList, String wordSign) {

        Symbol symbol;
        String symbolFromMatcher;
        Matcher matcher = Pattern.compile(REGEX_SYMBOL).matcher(wordSign);

        while (matcher.find()) {
            symbolFromMatcher = matcher.group();
            symbol = new Symbol(symbolFromMatcher);
            symbolList.add(symbol);
        }

        return symbolList;
    }

}