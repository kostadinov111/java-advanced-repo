package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;

public class Task_05_Write_Every_Third_Line {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            int counter = 0;
            String line;

            while (null != (line = bufferedReader.readLine())) {
                counter++;

                if (counter % 3 == 0) {
                    printWriter.println(line);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}