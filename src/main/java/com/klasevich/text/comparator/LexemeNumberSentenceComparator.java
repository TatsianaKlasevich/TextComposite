package com.klasevich.text.comparator;

import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;

import java.util.Comparator;

public class LexemeNumberSentenceComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return totalSentenceLength(o1) - totalSentenceLength(o2);
    }

    public int totalSentenceLength(TextComponent textComponent) {
        TextComposite sentence = (TextComposite) textComponent;
        int count = 0;
        for (TextComponent lexeme : sentence.getChildren()) {
            count += (lexeme).size();
        }
        return count;
    }
}
