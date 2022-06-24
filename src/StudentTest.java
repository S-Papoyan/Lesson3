import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) throws IOException {

        Path paths = Paths.get("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student.txt");
        String[] strings = Files.readAllLines(paths).toArray(new String[0]);

        for (int i = 0; i < strings.length; i++) { //Յուրաքանչյուր նոր Student-ի համար ստեղծվում է նոր ֆայլ և մեջը գրվում նրա անունը և տարիքը։
            List<String> lines = List.of(strings[i]);
            Path paths1 = Paths.get("C:\\Users\\spapo\\OneDrive\\Рабочий стол\\Student" + i + ".txt");
            Files.write(paths1, lines);
        }
    }
}







//    public static Student[] create(String[] names) {
//        Student[] students = new Student[names.length];
//        for (int i = 0; i < names.length; i++) {
//            String[] split = names[i].split(",");
//            Student student = new Student();
//            student.setName(split[0]);
//            student.setAge(Integer.parseInt(split[1]));
//            students[i] = student;
//        }
//        return students;
//    }
//    String[] name = {"Vigen,32", "Gor,28", "Arevik,21", "Sokrat,26", "Karen,25", "Edgar,36", "Sergey,34", "Georgi,20"};