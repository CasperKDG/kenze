package main.java.com.cvanbogaert.kenze.domain;

import main.java.com.cvanbogaert.kenze.config.AppConfig;

import java.util.Objects;

/**
 * A Word has an immutable String text that will be used to find combinations for.
 */
public class Word {
    private static final int WORD_LENGTH = AppConfig.WORD_LENGTH;
    private final String text;

    /**
     * Creates a new Word with the given text.
     * @param text The given String text must be exactly the length defined in the AppConfig.
     */
    public Word(String text) {
        if(text!=null && text.length()==WORD_LENGTH) {
            this.text = text;
        } else {
            throw new IllegalArgumentException(String.format("Words must be %d characters long", WORD_LENGTH));
        }
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return getText().equals(word.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText());
    }
}
