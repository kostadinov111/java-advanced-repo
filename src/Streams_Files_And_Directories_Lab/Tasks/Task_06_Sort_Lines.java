package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task_06_Sort_Lines {
    public static void main(String[] args) {

        String inputPath = "src/Streams_Files_And_Directories_Lab/Resources/input.txt";
        String outputPath = "src/Streams_Files_And_Directories_Lab/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))) {

            List<String> lines = new ArrayList<>();

            String line;

            while (null != (line = bufferedReader.readLine())) {
                lines.add(line);
            }

            Collections.sort(lines);

            for (String singleLine : lines) {
                printWriter.println(singleLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}