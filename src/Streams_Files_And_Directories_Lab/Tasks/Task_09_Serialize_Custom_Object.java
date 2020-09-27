package Streams_Files_And_Directories_Lab.Tasks;

import java.io.*;

public class Task_09_Serialize_Custom_Object {
    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public String getColor() {
            return this.color;
        }

        public double getWidth() {
            return this.width;
        }

        public double getHeight() {
            return this.height;
        }

        public double getDepth() {
            return this.depth;
        }

    }
    public static void main(String[] args) {

        String path = "src/Streams_Files_And_Directories_Lab/Resources/cube.ser";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {

            // initialize object from class Cube
            Cube cube = new Cube("green", 15.3, 12.4, 3.0);

            objectOutputStream.writeObject(cube);

            Cube cubeDeserialized = (Cube) objectInputStream.readObject();

            // print cubeDeserialized to check if deserialization is correct
            System.out.println(String.format("Color: %s%nWidth: %.1f%nHeight: %.1f%nDepth: %.1f",
                    cubeDeserialized.getColor(), cubeDeserialized.getWidth(), cubeDeserialized.getHeight(), cubeDeserialized.getDepth()));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}