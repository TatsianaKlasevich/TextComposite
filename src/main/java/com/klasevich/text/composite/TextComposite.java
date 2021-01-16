package com.klasevich.text.composite;

import com.klasevich.text.composite.type.CompositeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TextComposite implements TextComponent {
    private static final Logger logger = LogManager.getLogger();
    private List<TextComponent> textComponents = new ArrayList<>();
    private CompositeType type;

    public TextComposite(CompositeType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    public CompositeType getType() {
        return type;
    }

    public int size() {
        return textComponents.size();
    }

    @Override
    public Optional<TextComponent> getChild(int index) {
        Optional<TextComponent> result = Optional.empty();
        if (index >= 0 && index < textComponents.size()) {
            result = Optional.of(textComponents.get(index));
        }
        return result;
    }

    public List<TextComponent> getChildren() {
        return Collections.unmodifiableList(textComponents);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String delimiter = type.getTypeDelimiter();
        int typeCutLength = type.getTypeCutLength();
        for (TextComponent textComponent : textComponents) {
            String text = String.join(delimiter, textComponent.toString());
            builder.append(text).append(delimiter);
        }
        builder.delete(builder.length() - typeCutLength, builder.length());
        return builder.toString();
    }
}
