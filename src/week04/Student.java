package week04;

public class Student {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    //set은 실무에서 쓰지 말긔!

    public Student(String name, int score ) {
        this.name = name;
        //this.name => 저기 밖에 있는 name이라는 뜻
        this.score = score;
    }
}
