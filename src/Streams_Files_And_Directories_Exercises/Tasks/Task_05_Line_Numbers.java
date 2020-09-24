package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_05_Line_Numbers {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/inputLineNumbers.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            int index = 0;

            String line = bufferedReader.readLine();

            while (null != line) {
                index++;
                printWriter.println(String.format("%d. %s", index, line));
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}