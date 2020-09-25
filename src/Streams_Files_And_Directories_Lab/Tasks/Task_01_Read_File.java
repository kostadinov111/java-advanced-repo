package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;

public class Task_01_Read_File {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}