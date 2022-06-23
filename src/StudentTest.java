import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class StudentTest {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Students.txt");
        String[] name = {"Vigen,32", "Gor,28", "Arevik,21", "Sokrat,26", "Karen,25", "Edgar,36", "Sergey,34", "Georgi,20"};
        fileWriter.write(Arrays.toString(name));
        fileWriter.close();

        Path paths = Paths.get("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Students.txt");
        String[] strings = Files.readAllLines(paths).toArray(new String[0]);
        String s = strings[0];
        String[] stringToArrayString = s.split(",");

    }

    public static Student[] create(String[] names) {
        Student[] students = new Student[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] split = names[i].split(",");
            Student student = new Student();
            student.setName(split[0]);
            student.setAge(Integer.parseInt(split[1]));
            students[i] = student;
        }
        return students;
    }
}
