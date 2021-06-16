package main.java.com.cvanbogaert.kenze;

import main.java.com.cvanbogaert.kenze.config.AppConfig;
import main.java.com.cvanbogaert.kenze.services.WordService;
import main.java.com.cvanbogaert.kenze.services.WordServiceImpl;
import main.java.com.cvanbogaert.kenze.util.FileUtils;

import java.util.List;

public class SixLetterWordApplication {
    public static void main(String[] args) {
        List<String> entries = FileUtils.readFile(AppConfig.FILE_PATH);
        WordService wordService = new WordServiceImpl(AppConfig.WORD_LENGTH);
        wordService.listCombinations(entries);
    }
}
