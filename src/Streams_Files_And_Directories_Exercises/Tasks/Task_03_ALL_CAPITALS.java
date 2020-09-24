package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_03_ALL_CAPITALS {
    public static void main(String[] args) {
        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = bufferedReader.readLine();

            while (null != line) {

                StringBuilder currentLine = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (97 <= symbol && symbol <= 122) {
                        symbol = (char) (symbol - 32);
                    }

                    currentLine.append(symbol);
                }

                printWriter.println(currentLine);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}