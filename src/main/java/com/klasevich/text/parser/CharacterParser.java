package com.klasevich.text.parser;

import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.composite.TextLeaf;
import com.klasevich.text.composite.type.CompositeType;
import com.klasevich.text.composite.type.LeafType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterParser extends AbstractParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private static final String CHARACTER_REGEX = "[\\d\\p{L}']";

    @Override
    public TextComposite parse(String lexeme) {
        TextComposite characters = new TextComposite(CompositeType.CHARACTER);
        char[] lexemeChars = lexeme.toCharArray();
        for (char lexemeChar : lexemeChars) {
            TextLeaf leaf = null;
            if (isPunctuation(lexemeChar)) {
                leaf = new TextLeaf(LeafType.PUNCTUATION, lexemeChar);
            }
            if (isWordCharacter(lexemeChar)) {
                leaf = new TextLeaf(LeafType.CHARACTER, lexemeChar);
            }
            if (leaf != null) {
                characters.add(leaf);
            }
        }
        logger.debug(characters.toString());
        return characters;
    }

    private boolean isWordCharacter(char character) {
        String characterString = String.valueOf(character);
        Pattern pattern = Pattern.compile(CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(characterString);
        return matcher.matches();
    }

    private boolean isPunctuation(char character) {
        String characterString = String.valueOf(character);
        Pattern pattern = Pattern.compile(PUNCTUATION_REGEX);
        Matcher matcher = pattern.matcher(characterString);
        return matcher.matches();
    }
}
