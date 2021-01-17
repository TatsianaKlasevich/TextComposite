package com.klasevich.text.data;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.parser.AbstractParser;
import com.klasevich.text.parser.ParagraphParser;
import com.klasevich.text.parser.SentenceParser;

import java.util.ArrayList;
import java.util.List;

public class BasicData {
    public static final String BASIC_TEXT = "    It has survived - not only (five) centuries, but also the leap into electronic\r\n" +
            "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)\r\n" +
            "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\r\n" +
            "more recently with desktop publishing software like Aldus PageMaker Falcon9 including\r\n" +
            "versions of Lorem Ipsum!\r\n" +
            "    It is a long a!=b established fact that a reader will be distracted by the readable\r\n" +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a\r\n" +
            "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\r\n" +
            "content here's, making it look like readable English?\r\n" +
            "    It is a established fact that a reader will be of a page when looking at its layout...\r\n" +
            "    Bye бандерлоги.";
    public static final String PARSED_TEXT = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the Динамо (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Falcon9 including versions of Lorem Ipsum!   It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?  It is a established fact that a reader will be of a page when looking at its layout...    Bye бандерлоги.";
    public static final String BASIC_PARAGRAPH = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the Динамо (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Falcon9 including versions of Lorem Ipsum!";
    public static final String PARSED_PARAGRAPH = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the Динамо (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Falcon9 including versions of Lorem Ipsum!";
    public static final String BASIC_SENTENCE = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";
    public static final String PARSED_SENTENCE = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";
    public static final String BASIC_LEXEME = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";
    public static final String PARSED_LEXEME = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";
    public static final String BASIC_CHARACTER = "It has survived";
    public static final String PARSED_CHARACTER = "Ithassurvived";
    public static final String LONGEST_WORD_TEXT = "It was popularised in the Динамо (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Falcon9 including versions of Lorem Ipsum!";
    public static final List<TextComposite> SORTED_PARAGRAPH;
    public static final List<TextComposite> SORTED_SENTENCE;

    static {
        AbstractParser paragraphParser = new ParagraphParser();
        AbstractParser sentenceParser = new SentenceParser();
        TextComposite part;
        SORTED_PARAGRAPH = new ArrayList<>();
        SORTED_SENTENCE = new ArrayList<>();
        part = paragraphParser.parse("It is a established fact that a reader will be of a page when looking at its layout...");
        SORTED_PARAGRAPH.add(part);
        part = paragraphParser.parse("Bye бандерлоги.");
        SORTED_PARAGRAPH.add(part);
        part = paragraphParser.parse("It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Falcon9 including versions of Lorem Ipsum!");
        SORTED_PARAGRAPH.add(part);
        part = paragraphParser.parse("It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?");
        SORTED_PARAGRAPH.add(part);
        part = sentenceParser.parse("It was popularised in the Динамо (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Falcon9 including versions of Lorem Ipsum!");
        SORTED_SENTENCE.add(part);
        part = sentenceParser.parse("The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?");
        SORTED_SENTENCE.add(part);
        part = sentenceParser.parse("It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout.");
        SORTED_SENTENCE.add(part);
    }

    private BasicData() {
    }
}
