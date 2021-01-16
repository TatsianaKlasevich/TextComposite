package com.klasevich.text.composite;

import java.util.Optional;

public interface TextComponent {
    String toString();

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    Optional<TextComponent> getChild(int index);

    public int size();
}
