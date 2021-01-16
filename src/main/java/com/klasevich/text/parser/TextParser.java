package com.klasevich.text.parser;

import com.klasevich.text.composite.type.CompositeType;
import com.klasevich.text.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String TEXT_DELIMITER_REGEX = "\\r\\n";
    private static final String TEXT_REPLACEMENT = " ";
    private AbstractParser paragraphParser = new ParagraphParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite textComposite = new TextComposite(CompositeType.TEXT);
        String textNew = text.replaceAll(TEXT_DELIMITER_REGEX, TEXT_REPLACEMENT);
        TextComposite paragraph = paragraphParser.parse(textNew);
        textComposite.add(paragraph);
        logger.info(textComposite.toString());
        return textComposite;
    }
}
