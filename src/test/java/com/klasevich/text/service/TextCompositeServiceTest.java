package com.klasevich.text.service;

import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.data.BasicData;
import com.klasevich.text.parser.AbstractParser;
import com.klasevich.text.parser.TextParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TextCompositeServiceTest {
    public TextCompositeService service;
    public AbstractParser parser = new TextParser();
    TextComposite composite;

    @BeforeMethod
    public void setUp() {
        service = new TextCompositeService();
        composite = parser.parse(BasicData.BASIC_TEXT);
    }

    @Test
    public void testSortParagraphsBySentenceNumber() {
        List<TextComposite> expected = BasicData.SORTED_PARAGRAPH;
        List<TextComponent> actual = service.sortParagraphsBySentenceNumber(composite);
        assertEquals(actual, expected);
    }
}