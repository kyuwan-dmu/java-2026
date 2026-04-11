package week05;

import week04.Student;

public class Week05Main {

    public static void main(String[] args) {

        Student student = new Student("A");
        Student student2 = new Student(20);
        Student student3 = new Student("A",100);

        System.out.println(student.getName());
        System.out.println(student.getScore());

    }
}
