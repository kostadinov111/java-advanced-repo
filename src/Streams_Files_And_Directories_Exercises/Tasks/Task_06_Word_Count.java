package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_06_Word_Count {
    public static void main(String[] args) {

        String inputPath1 = "src/Streams_Files_And_Directories_Exercises/Resources/words.txt";
        String inputPath2 = "src/Streams_Files_And_Directories_Exercises/Resources/text.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(inputPath1));
             Scanner sc = new Scanner(new FileReader(inputPath2));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            String[] words = bufferedReader1.readLine().split("\\s+");
            Map<String, Integer> wordCount = new LinkedHashMap<>();

            for (String word : words) {
                wordCount.put(word, 0);
            }

            while (sc.hasNext()) {
                String word = sc.next();

                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                }

            }

            StringBuilder output = new StringBuilder();

            wordCount
                    .entrySet()
                    .stream()
                    .sorted((word1, word2) -> Integer.compare(word2.getValue(), word1.getValue()))
                    .forEach(word -> output.append(String.format("%s - %d%n", word.getKey(), word.getValue())));

            printWriter.print(output);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}