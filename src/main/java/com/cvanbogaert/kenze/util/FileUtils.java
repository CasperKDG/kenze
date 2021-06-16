package main.java.com.cvanbogaert.kenze.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static List<String> readFile(String path) {
        File file = new File(path);
        List<String> entries = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                entries.add(scanner.nextLine().toLowerCase().trim());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File wasn't found!");
            e.printStackTrace();
        }
        //Collections.sort(entries);
        return entries;
    }
}
