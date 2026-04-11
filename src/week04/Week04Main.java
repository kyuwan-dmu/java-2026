package week04;

import java.util.Objects;

public class Week04Main {

    public static void main(String[] args) {

        Student[] students = new Student[10];

        for (int i = 0; i < students.length; i++) {
           if(students[i].name.contains("학")){

           }
        }

        for (Student student : students) {
            System.out.printf(student.name + " " + student.score);
        }

    }

}
