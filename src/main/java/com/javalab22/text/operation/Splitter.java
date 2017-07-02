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
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";

    public Splitter() {
    }

    public TextComposite split(String text) {
        TextComposite wholeText = new TextComposite();
        wholeText = parseToParagraph(wholeText, text);
        wholeText.print();
        return wholeText;
    }

    private TextComposite parseToParagraph(TextComposite wholeText, String text) {
        TextComposite paragraphList = new TextComposite();
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        String paragraph;
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            paragraph = matcher.group();
            paragraphList = parseToSentense(paragraphList, paragraph);
            wholeText.add(paragraphList);
            //System.out.print(paragraph);
        }

        return wholeText;
    }

    private TextComposite parseToSentense(TextComposite paragraphList, String paragraph) {

        TextComposite sentenceList = new TextComposite();
        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher m2 = patternSentence.matcher(paragraph);
        String sentence;
        while (m2.find()) {
            sentence = m2.group();
            sentenceList = parseToWord(sentenceList, sentence);
            //System.out.println(sentence);
            paragraphList.add(sentenceList);
        }
        return paragraphList;
    }

    private TextComposite parseToWord(TextComposite sentenceList, String sentence) {

        Pattern patternWord = Pattern.compile(REGEX_WORD);
        String word;
        Matcher matcher = patternWord.matcher(sentence);
        TextComposite wordList = new TextComposite();
        while (matcher.find()) {
            word = matcher.group();
            wordList = parseToSignAndWord(wordList, word);
            sentenceList.add(wordList);
            //System.out.println(word);
        }
        return sentenceList;
    }

    private TextComposite parseToSignAndWord(TextComposite wordList, String word) {
        Pattern pattern = Pattern.compile(REGEX_WORD_AND_SIGN);
        String wordSign;
        Matcher matcher = pattern.matcher(word);
        TextComposite wordSignList = new TextComposite();
        while (matcher.find()) {
            wordSign = matcher.group();
            wordSignList = parseToSymbol(wordSignList, wordSign);
            wordList.add(wordSignList);
            //System.out.println(wordSign);
        }
        return wordList;
    }

    private TextComposite parseToSymbol(TextComposite wordSignList, String wordSign) {

        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        String symbol;
        Matcher matcher = pattern.matcher(wordSign);
        Symbol symbolList;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolList = new Symbol(symbol);
            //System.out.println(symbol);
            //symbolList.print();
        }
        return wordSignList;
    }

}
