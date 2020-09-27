package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_09_Copy_A_Picture {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Exercises/Resources/img.jpg";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/picture-copy.jpg";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            byte[] copyBytes = fileInputStream.readAllBytes();
            fileOutputStream.write(copyBytes);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}