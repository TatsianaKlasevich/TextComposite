package com.klasevich.text.service;

import com.klasevich.text.comparator.SentenceNumberComparator;
import com.klasevich.text.composite.TextComponent;
import com.klasevich.text.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextCompositeService {
    private static final Logger logger = LogManager.getLogger();
    public List<TextComponent> sortParagraphsBySentenceNumber(TextComposite textComposite){
        List<TextComponent> paragraphs = new ArrayList<>(textComposite.getChildren());
        Comparator<TextComponent> comparator = new SentenceNumberComparator();
        paragraphs.sort(comparator);
        logger.debug(paragraphs);
        return paragraphs;
    }
}