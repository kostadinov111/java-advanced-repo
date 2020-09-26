package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Task_08_Nested_Folders {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/Files-and-Streams";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            File dir = new File(inputPath);
            Deque<File> queue = new ArrayDeque<>();
            int[] count = {1};

            queue.offer(dir);

            while (!queue.isEmpty()) {

                File currentDir = queue.poll();
                printWriter.println(currentDir.getName());
                File[] files = currentDir.listFiles();

                for (File file : files) {
                    if (file.isDirectory()) {
                        count[0]++;
                        queue.offer(file);
                    }
                }

            }

            printWriter.println(String.format("%d folders", count[0]));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}