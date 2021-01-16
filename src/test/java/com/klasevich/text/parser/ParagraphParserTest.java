package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {
    AbstractParser parser = new ParagraphParser();

    @Test
    public void testParse() {
        String basicParagraph = BasicData.BASIC_PARAGRAPH;
        String expected = BasicData.PARSED_PARAGRAPH;
        TextComposite composite = parser.parse(basicParagraph);
        String actual = composite.toString();
        assertEquals(actual, expected);
    }
}