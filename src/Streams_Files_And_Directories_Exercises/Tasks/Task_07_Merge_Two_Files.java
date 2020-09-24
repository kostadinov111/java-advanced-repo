package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_07_Merge_Two_Files {
    public static void main(String[] args) {

        String inputPathOne = "src/Streams_Files_And_Directories_Exercises/Resources/inputOne.txt";
        String inputPathTwo = "src/Streams_Files_And_Directories_Exercises/Resources/inputTwo.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReaderOne = new BufferedReader(new FileReader(inputPathOne));
             BufferedReader bufferedReaderTwo = new BufferedReader(new FileReader(inputPathTwo));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            String line;

            while (null != (line = bufferedReaderOne.readLine())) {
                printWriter.println(line);
            }

            while (null != (line = bufferedReaderTwo.readLine())) {
                printWriter.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}