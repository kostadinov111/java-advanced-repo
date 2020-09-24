package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;
import java.util.Set;

public class Task_04_Count_Character_Types {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = bufferedReader.readLine();
            int vowelsSum = 0;
            int consonantsSum = 0;
            int punctuationSum = 0;

            Set<Character> punctuationMarks = Set.of('(', '!', ',', '.', '?', ')');
            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

            while (null != line) {

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (Character.isLowerCase(symbol) && vowels.contains(symbol)) {
                        vowelsSum++;
                    } else if (punctuationMarks.contains(symbol)) {
                        punctuationSum++;
                    } else if (symbol != ' ') {
                        consonantsSum++;
                    }

                }

                line = bufferedReader.readLine();
            }

            printWriter.println(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d", vowelsSum, consonantsSum, punctuationSum));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}