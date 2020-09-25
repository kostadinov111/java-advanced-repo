package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;

public class Task_03_Copy_Bytes {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            int oneByte = fileInputStream.read();
            int space = ' ';
            int newLine = '\n';

            while (oneByte != -1) {

                if (oneByte != space && oneByte != newLine) {

                    String numericValue = String.valueOf(oneByte);

                    for (int index = 0; index < numericValue.length(); index++) {
                        fileOutputStream.write(numericValue.charAt(index));
                    }

                } else {
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}