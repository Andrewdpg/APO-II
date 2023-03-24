package model;

import java.lang.reflect.Field;

public class Student {

    public String name;
    public String code;
    public Integer age;

    public Student(String name, String code, int age) {
        this.name = name;
        this.code = code;
        this.age = age;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setField(String fieldName, Object value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
        Field field = Student.class.getDeclaredField(fieldName);
        if (field.getType() == Integer.class) {
            field.set(this, Integer.valueOf(value.toString()));
        } else {
            field.set(this, field.getType().cast(value.toString()));
        }
    }

    @Override
    public String toString() {
        return getName() + " - " + getCode() + " - " + getAge();
    }

    public String toSavingTableFormat()
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        String value = "";
        for (String column : savingTableStructure().split(StudentList.separator)) {
            value += (value != "" ? StudentList.separator : "") + Student.class.getDeclaredField(column).get(this);
        }
        return value;
    }

    public static String savingTableStructure() {
        String value = "";
        for (Field field : Student.class.getDeclaredFields()) {
            value += (value != "" ? StudentList.separator : "") + field.getName();
        }
        return value;
    }
}
