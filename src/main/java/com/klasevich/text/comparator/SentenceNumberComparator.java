package com.klasevich.text.comparator;

import com.klasevich.text.composite.TextComponent;

import java.util.Comparator;

public class SentenceNumberComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return (o1.size() - o2.size());
    }
}
