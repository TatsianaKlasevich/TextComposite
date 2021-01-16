package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharacterParserTest {
    AbstractParser parser = new CharacterParser();

    @Test
    public void testParse() {
        String basicText = BasicData.BASIC_CHARACTER;
        String expected = BasicData.PARSED_CHARACTER;
        TextComposite composite = parser.parse(basicText);
        String actual = composite.toString();
        assertEquals(actual, expected);
    }
}