import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static Map<String, Integer> calculateWordFrequency(String filename) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequency) {
        TreeMap<Integer, String> sortedWordFrequency = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            sortedWordFrequency.put(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<Integer, String> entry : sortedWordFrequency.descendingMap().entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
