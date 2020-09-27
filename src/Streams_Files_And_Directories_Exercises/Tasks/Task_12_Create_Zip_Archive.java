package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Task_12_Create_Zip_Archive {
    public static void main(String[] args) {

        String inputPath1 = "src/Streams_Files_And_Directories_Exercises/Resources/input.txt";
        String inputPath2 = "src/Streams_Files_And_Directories_Exercises/Resources/inputOne.txt";
        String inputPath3 = "src/Streams_Files_And_Directories_Exercises/Resources/inputTwo.txt";
        String outputPath = "src/Streams_Files_And_Directories_Exercises/files.zip";

        List<String> files = new ArrayList<>();

        // add few files to be zipped
        files.add(inputPath1);
        files.add(inputPath2);
        files.add(inputPath3);

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

            for (String file : files) {
                zipOutputStream.putNextEntry(new ZipEntry(new File (file).getName()));

                byte[] bytes = Files.readAllBytes(Paths.get(file));
                zipOutputStream.write(bytes, 0, bytes.length);
                zipOutputStream.closeEntry();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}