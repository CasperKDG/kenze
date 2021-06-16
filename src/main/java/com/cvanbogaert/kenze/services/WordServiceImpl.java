package main.java.com.cvanbogaert.kenze.services;

import main.java.com.cvanbogaert.kenze.domain.Combinator;
import main.java.com.cvanbogaert.kenze.domain.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordServiceImpl implements WordService {
    private final int WORD_LENGTH;

    public WordServiceImpl(int wordLength) {
        this.WORD_LENGTH = wordLength;
    }

    @Override
    public void listCombinations(List<String> entries) {
        List<Word> words = entries.stream().filter(e -> e.length() == WORD_LENGTH).map(Word::new).distinct().collect(Collectors.toList());
        List<Combinator> combinators = entries.stream().filter(e -> e.length() < WORD_LENGTH).map(Combinator::new).collect(Collectors.toList());

        for (Word word : words) {
            List<Combinator> wordCombinators = new ArrayList<>();
            for (Combinator combinator1 : combinators) {
                if (word.getText().contains(combinator1.getText())) {
                    wordCombinators.add(combinator1);
                }
            }

            List<String> usedCombinations = new ArrayList<>();
            for (Combinator wordStartCombinator : wordCombinators) {
                if (word.getText().startsWith(wordStartCombinator.getText())) {
                    List<Combinator> removedCombinators = wordCombinators.stream().filter(e -> !e.equals(wordStartCombinator)).collect(Collectors.toList());
                    loop(word, removedCombinators, new ArrayList<>(List.of(wordStartCombinator)), usedCombinations);
                }
            }
        }
    }

    /**
     * Loops over the given wordCombinators to find combinations with the given combinationList that match the given word.
     * @param word The given word to find combinations for.
     * @param wordCombinators The list of Combinators to combine in order to match the given word.
     * @param combinationList The current combination of Combinators used, in chronological order.
     * @param usedCombinations The list of valid combinations that have been printed to the console, used to check duplicates.
     */
    private void loop(Word word, List<Combinator> wordCombinators, List<Combinator> combinationList, List<String> usedCombinations) {
        for (Combinator additionalCombinator : wordCombinators) {
            combinationList.add(additionalCombinator);
            String combinedWord = combinationList.stream().map(Combinator::getText).collect(Collectors.joining(""));

            if (word.getText().startsWith(combinedWord)) {
                String combinatedWord = combinationList.stream().map(Combinator::getText).collect(Collectors.joining("+"));
                if (combinedWord.length() < 6) {
                    List<Combinator> newWordCombinators = new ArrayList<>(wordCombinators);
                    newWordCombinators.remove(additionalCombinator);
                    loop(word, newWordCombinators, new ArrayList<>(combinationList), usedCombinations);
                } else if (combinedWord.length() == 6 && combinedWord.equals(word.getText()) && !usedCombinations.contains(combinatedWord)) {
                    usedCombinations.add(combinatedWord);
                    System.out.println(combinatedWord + "=" + word.getText());
                }
            } else {
                combinationList.remove(additionalCombinator);
            }
        }
    }
}
