package week06.student;

public class Student {

    // TODO: 필드를 선언하세요
    private String name;
    private int score;
    private String grade;

    // TODO: 생성자를 만드세요
    public Student(String name, int score){
        this.name = name;
        this.score = score;
        this.grade = calGrade(score);
    }
    public String calGrade(int score){
        if(score >= 90) return "A";
        if(score >= 80) return "B";
        if(score >= 70) return "C";
        if(score >= 60) return "D";
        return "F";
    }

    // TODO: 메서드를 만드세요
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String getGrade(){
        return grade;
    }
}
