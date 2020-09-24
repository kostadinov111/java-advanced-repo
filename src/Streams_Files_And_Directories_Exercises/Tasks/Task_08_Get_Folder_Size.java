package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_08_Get_Folder_Size {
    public static void main(String[] args) {

        String outputPath = "src/Streams_Files_And_Directories_Exercises/output.txt";
        String directory = "src/Streams_Files_And_Directories_Exercises/Resources/";

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            File dir = new File(directory);
            long size = folderSize(dir);
            printWriter.println(String.format("Folder size: %d", size));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long folderSize(File dir) {
        long len = 0;

        for (File file : dir.listFiles()) {

            if (file.isFile()) {
                len += file.length();
            } else {
                folderSize(file);
            }

        }

        return len;
    }

}