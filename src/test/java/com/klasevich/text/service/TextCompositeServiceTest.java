package com.klasevich.text.service.impl;

import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import com.klasevich.text.parser.AbstractParser;
import com.klasevich.text.parser.ParagraphParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TextCompositeServiceTest {
    public TextCompositeServiceImpl service;
    public AbstractParser paragraphParser;
    public AbstractParser sentenceParser;


    @BeforeMethod
    public void setUp() {
        service = new TextCompositeServiceImpl();
        paragraphParser = new ParagraphParser();
        sentenceParser = new ParagraphParser();
    }

    @Test
    public void testSortParagraphBySentenceNumber() {
        TextComposite composite = paragraphParser.parse(BasicData.BASIC_TEXT);
        List<TextComposite> expected = BasicData.SORTED_PARAGRAPH;
        List<TextComponent> actual = service.sortParagraphBySentenceNumber(composite);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindSentenceWithMaxWordLength() {
        TextComposite composite = sentenceParser.parse(BasicData.BASIC_TEXT);
        TextComposite expected = sentenceParser.parse(BasicData.LONGEST_WORD_TEXT);
        TextComponent actual = service.findSentenceWithMaxWordLength(composite);
        assertEquals(actual, expected);
    }

    @Test
    public void testRemoveSentenceWithLessWordNumber() {
        int wordNumber = 19;
        TextComposite composite = sentenceParser.parse(BasicData.BASIC_TEXT);
        List<TextComposite> expected = BasicData.SORTED_SENTENCE;
        List<TextComponent> actual = service.removeSentenceWithLessWordNumber(composite, wordNumber);
        assertEquals(actual, expected);
    }
}