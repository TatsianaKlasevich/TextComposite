package com.klasevich.text.composite;

import com.klasevich.text.composite.type.LeafType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class TextLeaf implements TextComponent {
    private static Logger logger = LogManager.getLogger();
    private LeafType type;
    private char character;

    public TextLeaf(LeafType type, char character) {
        this.type = type;
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public void add(TextComponent textComponent) {
        logger.error("it's impossible to add component to leaf!");
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.error("it's impossible to remove component from leaf!");
    }

    @Override
    public Optional<TextComponent> getChild(int index) {
        logger.error("it's impossible to get child component from leaf!");
        return Optional.empty();
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextLeaf textLeaf = (TextLeaf) o;

        if (character != textLeaf.character) return false;
        return type == textLeaf.type;
    }

    @Override
    public int hashCode() {
        int result = character;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
