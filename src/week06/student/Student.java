package week06.student;

public class Student {

    // TODO: 필드를 선언하세요
    public String name;
    public int score;

    // TODO: 생성자를 만드세요
    public Student(String name) {
        this.name = name;
    }
    public Student(int score) {
        this.score = score;
    }
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // TODO: 메서드를 만드세요
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}
