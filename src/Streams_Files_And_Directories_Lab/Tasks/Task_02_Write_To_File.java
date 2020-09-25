package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;
import java.util.Set;

public class Task_02_Write_To_File {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             PrintWriter printWriter = new PrintWriter(outputPath)) {

            Set<Character> punctuationMarks = Set.of(',', '.', '!', '?');

            int oneByte = fileInputStream.read();

            while (oneByte != -1) {

                if (!punctuationMarks.contains((char) oneByte)) {
                    printWriter.print((char) oneByte);
                }

                oneByte = fileInputStream.read();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}