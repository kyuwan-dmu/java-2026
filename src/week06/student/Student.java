package week06.student;

import java.util.Scanner;

public class Student {

    // TODO: 필드를 선언하세요
    public String name = "이름없음";
    public int score = 0;

    public Student (String name, int score){
        this.name = name;
        this.score = score;
    }



    // TODO: 생성자를 만드세요


    // TODO: 메서드를 만드세요

    public String returnScore(int score){
        String message = "";
        if (90 <= score) {
            message = "학생의 점수는 A 등급 입니다.";
        }
        else if (80 <= score) {
            message = "학생의 점수는 B 등급 입니다.";
        }
        else if (70 <= score) {
            message = "학생의 점수는 C 등급 입니다.";
        }
        else {
            message = "학생의 점수는 F 등급 입니다.";
        }

        System.out.print(message + "\n");
        return message;
    }

}
