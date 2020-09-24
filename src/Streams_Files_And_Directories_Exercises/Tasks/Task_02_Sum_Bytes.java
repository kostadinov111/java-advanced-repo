package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_02_Sum_Bytes {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            long sum = 0;
            String line = bufferedReader.readLine();

            while (null != line) {

                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }

                line = bufferedReader.readLine();
            }

            printWriter.println(sum);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}