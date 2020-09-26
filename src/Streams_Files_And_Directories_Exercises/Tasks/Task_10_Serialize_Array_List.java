package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task_10_Serialize_Array_List {
    public static void main(String[] args) throws IOException {

        String outputPath = "src/Streams_Files_And_Directories_Exercises/list.ser";

        List<Double> numbers = new ArrayList<>();
        //adding few double values
        numbers.add(5.0d);
        numbers.add(7.2d);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputPath));
        objectOutputStream.writeObject(numbers);
        objectOutputStream.close();

    }
}