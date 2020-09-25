package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;

public class Task_07_List_Files {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/Files-and-Streams/";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            File file = new File(inputPath);

            for (File listFile : file.listFiles()) {
                if (listFile.isFile()) {
                    printWriter.println(String.format("%s: [%d]", listFile.getName(), listFile.length()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}