package week06.student;

public class Student {

    // TODO: 필드를 선언하세요
    private String name;
    private String grade;
    private int score;
    private static int countStud;
    private boolean pass;   // true면 합격, false는 불합

    // TODO: 생성자를 만드세요
    public Student(String name, int score) {
        setScore(score);
        this.name = name;
        setScore(score);
        countStud++;
    }
    public Student(String name) {
        this(name, 0);
    }
    public Student() {
        this("이름없음", 0);
    }

    // TODO: 메서드를 만드세요
    public void setScore(int score){
        if(score <= 100 && score >= 0) {
            System.out.println();
            this.score = score;
            isPass();
            compareScore();
        }
        else {
            System.out.println("조건에 않맞음");
        }
    }

    public void compareScore() {
        if (this.score >= 90){
            this.grade = "A";
        } else if (this.score >= 80) {
            this.grade = "B";
        } else if (this.score >= 70) {
            this.grade = "C";
        } else {
            this.grade = "F";
        }
    }

    void isPass(){      // default 접근제어자? 찾아봐서 찾음
        if (this.score >= 60){
            this.pass = true;    // 1이면 합 아니면 불합
        }
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public static int getCountStud() {
        return countStud;
    }

    public boolean getPass() {
        return pass;
    }
}