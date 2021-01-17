package com.klasevich.text.service;

import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;

import java.util.List;

public interface TextCompositeService {
    List<TextComponent> sortParagraphBySentenceNumber(TextComposite textComposite);
    TextComponent findSentenceWithMaxWordLength(TextComposite textComposite);
    public List<TextComponent> removeSentenceWithLessWordNumber(TextComposite compositeText, int number);
}