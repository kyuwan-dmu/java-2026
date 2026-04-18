package week06.student;

public class Student {

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public char getGrade(int score) {
        if (score>90)
            return 'A';
        else if (score>80)
            return 'B';
        else if (score>70)
            return 'C';
        else
            return 'F';
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }

    public Student(String name) {
        this.name = name;
    }
    // TODO: 필드를 선언하세요

    // TODO: 생성자를 만드세요

    // TODO: 메서드를 만드세요

}

