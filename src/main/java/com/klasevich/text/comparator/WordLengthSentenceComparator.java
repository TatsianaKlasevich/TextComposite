package com.klasevich.text.comparator;

import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.composite.TextLeaf;
import com.klasevich.text.composite.type.LeafType;

import java.util.Comparator;
import java.util.List;

public class WordLengthSentenceComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return wordLength(o1) - wordLength(o2);
    }

    private int wordLength(TextComponent textComponent) {
        TextComposite sentence = (TextComposite) textComponent;
        int count = 0;
        for (TextComponent lexeme : sentence.getChildren()) {
            List<TextComponent> chars = ((TextComposite) lexeme).getChildren();
            for (TextComponent ch : chars) {
                TextLeaf leaf = ((TextLeaf) ch);
                if (leaf.getType() == LeafType.CHARACTER) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
