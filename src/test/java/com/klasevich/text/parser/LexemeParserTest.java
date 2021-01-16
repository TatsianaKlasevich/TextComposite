package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeParserTest {
    AbstractParser parser = new LexemeParser();

    @Test
    public void testParse() {
        String basicText = BasicData.BASIC_LEXEME;
        String expected = BasicData.PARSED_LEXEME;
        TextComposite composite = parser.parse(basicText);
        String actual = composite.toString();
        assertEquals(actual, expected);
    }
}