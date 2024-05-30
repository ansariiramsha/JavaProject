import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Set<String> stopWords = new HashSet<>();

    static {
        // Add common stop words to the set (this list can be extended)
        stopWords.add("a");
        stopWords.add("an");
        stopWords.add("and");
        stopWords.add("the");
        stopWords.add("is");
        stopWords.add("in");
        stopWords.add("at");
        stopWords.add("of");
        stopWords.add("on");
        stopWords.add("to");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text directly or provide a file path:");

        String input = scanner.nextLine();
        String text = "";

        File file = new File(input);
        if (file.exists() && file.isFile()) {
            try (Scanner fileScanner = new Scanner(file)) {
                fileScanner.useDelimiter("\\Z");
                text = fileScanner.next();
            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
                return;
            }
        } else {
            text = input;
        }

        String[] words = text.split("\\W+");
        int wordCount = 0;
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word.toLowerCase())) {
                wordCount++;
                uniqueWords.add(word.toLowerCase());
            }
        }

        System.out.println("Total word count (excluding stop words): " + wordCount);
        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
