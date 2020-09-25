package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;

public class Task_01_Read_File {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             PrintWriter printWriter = new PrintWriter(outputPath)) {

            int oneByte = fileInputStream.read();

            while (oneByte != -1) {

                printWriter.print(String.format("%s ", Integer.toBinaryString(oneByte)));
                oneByte = fileInputStream.read();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}