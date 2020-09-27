package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task_10_Serialize_Array_List {
    public static void main(String[] args) throws ClassNotFoundException {

        String path = "src/Streams_Files_And_Directories_Exercises/list.ser";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {

            List<Double> numbers = new ArrayList<>();

            // adding few double values
            numbers.add(5.0d);
            numbers.add(7.2d);

            objectOutputStream.writeObject(numbers);

            List<Double> numbersDeserialized = (List<Double>) objectInputStream.readObject();

            // print numbersDeserialized to check if deserialization is correct
            System.out.println(numbersDeserialized.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}