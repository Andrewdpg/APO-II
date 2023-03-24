package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {

    private ArrayList<Student> students;
    private static String path = "C:/Users/andre/OneDrive/Documents/APO-students";
    public static final String separator = "/%/";

    public StudentList() {
        this.students = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void read() throws FileNotFoundException, IllegalArgumentException, IllegalAccessException,
            NoSuchFieldException, SecurityException {
        students = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File(path + "/students.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        Object[] lines = reader.lines().toArray();
        String[] params = lines[0].toString().split(separator);

        for (int i = 1; i < lines.length; i++) {
            Student student = new Student();
            for (int j = 0; j < params.length; j++) {
                student.setField(params[j], lines[i].toString().split(separator)[j]);
            }
            students.add(student);
        }
    }

    public void save() throws FileNotFoundException, IOException {

        File file = new File(path + "/students.txt");
        File folder = new File(path);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);
        String data = Student.savingTableStructure();
        for (Student student : students) {
            try {
                data += (data.isEmpty() ? "" : "\n") + student.toSavingTableFormat();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();

        System.out.println(Arrays.toString(folder.list()));
        fos.close();
    }

    public String toTable() {
        String value = "";
        for (Student student : students) {
            value += student.toString() + "\n";
        }
        return value;
    }
}