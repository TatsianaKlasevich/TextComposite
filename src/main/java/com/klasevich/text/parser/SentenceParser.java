package com.klasevich.text.parser;

import com.klasevich.text.composite.type.CompositeType;
import com.klasevich.text.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private AbstractParser lexemeParser = new LexemeParser();
    private static final String REGEX_SENTENCE = "(?<=[.!?…]\\s)";

    @Override
    public TextComposite parse(String paragraph) {
        TextComposite sentence = new TextComposite(CompositeType.SENTENCE);
        String[] sentences = paragraph.split(REGEX_SENTENCE);
        for (String element : sentences) {
            TextComposite sentenceComponent = lexemeParser.parse(element);
            sentence.add(sentenceComponent);
        }
        logger.debug(sentence.toString());
        return sentence;
    }
}
