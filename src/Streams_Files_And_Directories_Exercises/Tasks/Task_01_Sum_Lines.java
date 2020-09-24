package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_01_Sum_Lines {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = bufferedReader.readLine();

            while (null != line) {
                int sum = 0;

                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }

                printWriter.println(sum);

                line = bufferedReader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}