import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import model.Student;
import model.StudentList;

public class Main {

    static StudentList studentList = new StudentList();

    public static void main(String[] args) throws IOException {

        // Cargar la informacion
        studentList.load();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Añadir\n2.Mostrar\n3.Salir\n");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    // Nombre++Code++Edad
                    System.out.println("Escriba la entrada con el formato Nombre++Code++Edad");
                    String input = scanner.nextLine();
                    String[] data = input.split("\\+\\+");
                    System.out.println(Arrays.toString(data));
                    studentList.getStudents().add(
                            new Student(data[0], data[1], Integer.parseInt(data[2])));
                    studentList.save();
                    break;
                case 2:
                    studentList.show();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }

    }
}
