import java.util.Scanner;
import java.util.Arrays;

public class array {
    public static void main(String[] args){
        // 학생 점수 입력
        // 배열의 선언
        // 1) 선언과 동시에 값을 한번에 넣어버림 -> 넣은 값 만큼 공간이 알아서 생김
        //String[] students = {"학생1", "학생2", "학생3"};
        //int[] scores = {100, 90, 80};

        // 2) 선언 후 값을 출력
        //String[] Student1 = new String[10];
        //int[] score1 = new int[10];

        //System.out.println(">>>>" + Student1[0]);
        //System.out.println(">>>>" + score1[0]);

        Student[] students = {
                new Student("학생1", 100),
                new Student("학생2", 90),
                new Student("학생3", 80)
        };

        for(Student student : students){
         System.out.println(student.name + " " + student.score);
        }
    }
}