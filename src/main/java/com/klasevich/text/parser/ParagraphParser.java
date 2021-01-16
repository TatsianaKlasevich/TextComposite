package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.composite.type.CompositeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private AbstractParser sentenceParser = new SentenceParser();
    private static final String REGEX_PARAGRAPH = "\\s{4}";

    @Override
    public TextComposite parse(String text) {
        TextComposite paragraph = new TextComposite(CompositeType.PARAGRAPH);
        String[] paragraphs = text.trim().split(REGEX_PARAGRAPH);
        for (String element : paragraphs) {
            TextComposite sentence = sentenceParser.parse(element);
            paragraph.add(sentence);
        }
        logger.debug(paragraph.toString());
        return paragraph;
    }
}
