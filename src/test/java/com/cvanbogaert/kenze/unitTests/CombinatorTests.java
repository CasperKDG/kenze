package test.java.com.cvanbogaert.kenze.unitTests;
import main.java.com.cvanbogaert.kenze.config.AppConfig;
import main.java.com.cvanbogaert.kenze.domain.Combinator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinatorTests {
    private Combinator combinator;
    private int wordLength = AppConfig.WORD_LENGTH;

    @Before
    public void before() {
        combinator = null;
    }

    @Test
    public void createValidCombinator() {
        combinator = new Combinator("cas");
        assertEquals("cas", combinator.getText());
    }

    @Test
    public void createInvalidCombinator() {
        assertThrows(IllegalArgumentException.class, () -> {combinator = new Combinator("casper");});
    }
}
