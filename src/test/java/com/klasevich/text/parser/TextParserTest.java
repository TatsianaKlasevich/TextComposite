package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextParserTest {
    public AbstractParser parser = new TextParser();

    @Test
    public void testParse() {
        String basicText = BasicData.BASIC_TEXT;
        String expected = BasicData.PARSED_TEXT;
        TextComposite composite = parser.parse(basicText);
        String actual = composite.toString();
        assertEquals(actual, expected);
    }
}