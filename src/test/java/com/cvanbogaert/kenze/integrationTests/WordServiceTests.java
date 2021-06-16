package test.java.com.cvanbogaert.kenze.integrationTests;
import main.java.com.cvanbogaert.kenze.domain.Combinator;
import main.java.com.cvanbogaert.kenze.domain.Word;
import main.java.com.cvanbogaert.kenze.services.WordService;
import main.java.com.cvanbogaert.kenze.services.WordServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class WordServiceTests {
    private WordService wordService;
    private List<Combinator> combinators;
    private List<Word> words;
    private List<String> entries;

    @Before
    public void before() {
        wordService = new WordServiceImpl(6);
        combinators = new ArrayList<>(List.of(new Combinator("cas"), new Combinator("ca"), new Combinator("s"), new Combinator("per"), new Combinator("tle")));
        words = new ArrayList<>(List.of(new Word("casper"), new Word("castle"), new Word("kenze1")));

    }

    @Test
    public void testListCombinations() {
        //wordService.listCombinations(Stream.concat(words.stream(), combinators.stream()).collect(Collectors.toList()));
    }
}
