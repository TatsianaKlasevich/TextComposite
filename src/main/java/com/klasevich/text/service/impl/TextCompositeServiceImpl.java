package com.klasevich.text.service.impl;

import com.klasevich.text.comparator.LexemeNumberSentenceComparator;
import com.klasevich.text.comparator.SentenceNumberParagraphComparator;
import com.klasevich.text.comparator.WordLengthSentenceComparator;
import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;
import com.klasevich.text.service.TextCompositeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextCompositeServiceImpl implements TextCompositeService {
    private static final Logger logger = LogManager.getLogger();

    public List<TextComponent> sortParagraphBySentenceNumber(TextComposite textComposite) {
        List<TextComponent> paragraphs = new ArrayList<>(textComposite.getChildren());
        Comparator<TextComponent> comparator = new SentenceNumberParagraphComparator();
        paragraphs.sort(comparator);
        logger.debug(paragraphs);
        return paragraphs;
    }

    public TextComponent findSentenceWithMaxWordLength(TextComposite textComposite) {
        List<TextComponent> sentences = getAllSentences(textComposite);
        Comparator<TextComponent> comparator = new WordLengthSentenceComparator();
        sentences.sort(comparator);
        logger.debug(sentences);
        TextComponent max = sentences.get(sentences.size() - 1);
        return max;
    }

    public List<TextComponent> removeSentenceWithLessWordNumber(TextComposite compositeText, int number) {
        LexemeNumberSentenceComparator countSize = new LexemeNumberSentenceComparator();
        List<TextComponent> sentences = sortSentencesByWordNumber(compositeText);
        List<TextComponent> resultSentences = new ArrayList<>();
        for (int i = 0; i < sentences.size(); i++) {
            int sentenceSize = countSize.totalSentenceLength((TextComponent) sentences);
            if (sentenceSize >= number) {
                resultSentences.add(sentences.get(i));
            } else break;
        }
        logger.debug(resultSentences);
        return resultSentences;
    }

    private List<TextComponent> sortSentencesByWordNumber(TextComposite compositeText) {
        List<TextComponent> sentences = getAllLexemes(compositeText);
        Comparator<TextComponent> comparator =
                new LexemeNumberSentenceComparator();
        sentences.sort(comparator);
        return sentences;
    }

    private List<TextComponent> getAllSentences(TextComposite text) {
        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent paragraph : text.getChildren()) {
            sentences.addAll(((TextComposite) paragraph).getChildren());
        }
        logger.debug(sentences);
        return sentences;
    }

    private List<TextComponent> getAllLexemes(TextComposite compositeText) {
        List<TextComponent> lexemes = new ArrayList<>();
        for (TextComponent paragraph : compositeText.getChildren()) {
            for (TextComponent sentence : ((TextComposite) paragraph).getChildren()) {
                lexemes.addAll(((TextComposite) sentence).getChildren());
            }
        }
        return lexemes;
    }
}

