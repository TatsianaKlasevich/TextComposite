package com.klasevich.text.reader;

import com.klasevich.text.data.BasicData;
import com.klasevich.text.exception.ReaderException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextReaderTest {
    public TextReader reader = new TextReader();

    @Test
    public void testReadingFromFile() throws ReaderException {
        String actual = reader.readingFromFile("data/text.txt");
        String expected = BasicData.BASIC_TEXT;
        assertEquals(actual, expected);
    }
}