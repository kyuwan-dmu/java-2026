package week06.student;

public class Student {

    // TODO: 필드를 선언하세요
    String name;
    int score;
    String grade;

    Student() {
        String name = "이름없음";
        int score = 0;
        String grade = "F";
    }

    // TODO: 생성자를 만드세요
    public Student(String name, int score, String grade) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    Student(String name) {
        this.name = name;
    }

    Student(int score) {
        this.score = 0;
    }

}
    // TODO: 메서드를 만드세요


