import java.util.Scanner;

import model.Student;
import model.StudentList;

public class Main {

    private static Scanner scn = new Scanner(System.in);
    private static StudentList list;

    public static void main(String[] args) {
        list = new StudentList();
        try {
            list.read();
        } catch (Exception e) {
            System.out.println("Error al cargar los datos");
        }
        int option = -1;
        while (option != 0) {
            try {
                System.out.print(
                        "1. Ingresar estudiante.\n2. Tabla de estudiantes \n0. Salir\nOpcion:");
                option = Integer.parseInt(scn.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("Escriba el estudiante con el formato: " + Student.savingTableStructure());
                        String value = scn.nextLine();
                        Student student = new Student();
                        for (int i = 0; i < Student.savingTableStructure().split(StudentList.separator).length; i++) {
                            student.setField(Student.savingTableStructure().split(StudentList.separator)[i],
                                    value.split(StudentList.separator)[i]);
                        }
                        list.getStudents().add(student);
                        list.save();
                        break;
                    case 2:
                        System.out.println("Lista: \n\n" + list.toTable());
                        break;
                    default:
                        System.out.println("Opción no reconocida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Parece que ha habido un error, intena nuevamente");
                e.printStackTrace();
            }
        }

    }
}
