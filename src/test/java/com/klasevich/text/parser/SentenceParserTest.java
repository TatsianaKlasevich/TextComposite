package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceParserTest {
    public AbstractParser parser = new SentenceParser();

    @Test
    public void testParse() {
        String basicText = BasicData.BASIC_SENTENCE;
        String expected = BasicData.PARSED_SENTENCE;
        TextComposite composite = parser.parse(basicText);
        String actual = composite.toString();
        assertEquals(actual, expected);
    }
}