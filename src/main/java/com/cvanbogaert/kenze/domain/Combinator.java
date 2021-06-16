package main.java.com.cvanbogaert.kenze.domain;

import main.java.com.cvanbogaert.kenze.config.AppConfig;

public class Combinator {
    private final String text;
    private static final int WORD_LENGTH = AppConfig.WORD_LENGTH;

    /**
     * Creates a new Combinator with the given text.
     * @param text The given String text length must be smaller the length defined in the AppConfig.
     */
    public Combinator(String text) {
        if(text.length() < WORD_LENGTH){
            this.text = text;
        } else {
            throw new IllegalArgumentException("Combinators must be shorter than Words");
        }
    }

    public String getText() {
        return text;
    }
}
