package com.klasevich.text.parser;

import com.klasevich.text.composite.type.CompositeType;

import com.klasevich.text.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private AbstractParser characterParser = new CharacterParser();
    private static final String REGEX_LEXEME_DELIMITER = "\\s+";

    @Override
    public TextComposite parse(String text) {
        TextComposite lexeme = new TextComposite(CompositeType.LEXEME);
        String[] lexemes = text.split(REGEX_LEXEME_DELIMITER);
        for (String element : lexemes) {
            TextComposite character = characterParser.parse(element);
            lexeme.add(character);
        }
        logger.debug(lexeme);
        return lexeme;
    }
}
