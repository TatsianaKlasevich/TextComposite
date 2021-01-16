package com.klasevich.text.composite.type;

public enum CompositeType {
    TEXT("    ", 4), PARAGRAPH(" ", 1), SENTENCE(" ", 1),
    LEXEME(" ", 1), CHARACTER("", 0);

    private final String typeDelimiter;
    private final int typeCutLength;

    CompositeType(String typeDelimiter, int typeCutLength) {
        this.typeDelimiter = typeDelimiter;
        this.typeCutLength = typeCutLength;
    }

    public String getTypeDelimiter() {
        return typeDelimiter;
    }

    public int getTypeCutLength() {
        return typeCutLength;
    }
}
