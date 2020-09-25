package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;
import java.util.Scanner;

public class Task_04_Extract_Integers {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (Scanner sc = new Scanner(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    printWriter.println(sc.nextInt());
                }
                sc.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}