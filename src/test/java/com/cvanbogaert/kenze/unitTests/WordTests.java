package test.java.com.cvanbogaert.kenze.unitTests;

import main.java.com.cvanbogaert.kenze.domain.Word;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTests {
    private Word word;

    @Before
    public void before() {
        word = null;
    }

    @Test
    public void createValidWord() {
        word = new Word("casper");
        assertEquals("casper", word.getText());
    }

    @Test
    public void createTooShortWord(){
        assertThrows(IllegalArgumentException.class, () -> {word = new Word("cas");});
    }

    @Test
    public void createTooLongWord(){
        assertThrows(IllegalArgumentException.class, () -> {word = new Word("caspervanbogaert");});
    }
}
