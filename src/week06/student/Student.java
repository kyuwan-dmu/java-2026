package week06.student;

public class Student {

    // TODO: 필드를 선언하세요
    private String name;
    private int score;

    // TODO: 생성자를 만드세요
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    // TODO: 메서드를 만드세요
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
}
