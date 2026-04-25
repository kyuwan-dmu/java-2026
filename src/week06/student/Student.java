package week06.student;

import java.util.Scanner;

public class Student {

    // TODO: 필드를 선언하세요
    public String name = "이름없음";

    public int score = 0;

    public Student(){
        this("이름없음", 0);
        // defualt : 이름도 점수도 모를때
    }
    public Student(String name  ){
        this(name, 0);
        // 이름은 알고 점수는 모를때
    }

    public Student (String name, int score){
        this.name = name;
        this.score = score;
//        다 알고 있을 때
    }

    // TODO: 생성자를 만드세요


    // TODO: 메서드를 만드세요

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getGrande(){
        if (90 <= score) return "A";
        else if (80 <= score) return "B";
        else if (70 <= score) return "C";
        return "F";
    }

    public void printGrande(){
        System.out.print(getGrande());
    }

}
