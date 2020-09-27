package Streams_Files_And_Directories_Exercises.Tasks;

import java.io.*;

public class Task_11_Serialize_Custom_Object {
    public static class Course implements Serializable {
        private String courseName;
        private int numberOfStudents;

        public Course(String courseName, int numberOfStudents) {
            this.courseName = courseName;
            this.numberOfStudents = numberOfStudents;
        }

        public String getCourseName() {
            return this.courseName;
        }

        public int getNumberOfStudents() {
            return this.numberOfStudents;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        String path = "src/Streams_Files_And_Directories_Exercises/course.ser";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {

            // initialize object from class Course
            Course course = new Course("Java", 1024);

            objectOutputStream.writeObject(course);

            Course courseDeserialized = (Course) objectInputStream.readObject();

            // print courseDeserialized to check if deserialization is correct
            System.out.println(String.format("Course: %s%nNumber of students: %d", courseDeserialized.getCourseName(), courseDeserialized.getNumberOfStudents()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}