package week06.student;

public class Student {

    private String name;
    private int score;
    private static int totalCount = 0;

    public Student(String name, int score) {
        this.name = name;
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            this.score = 0;
        }
        totalCount++;
    }

    public Student(String name) {
        this(name, 0);
    }

    public Student() {
        this("이름없음", 0);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean setScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        }
        this.score = score;
        return true;
    }

    public String getGrade() {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else {
            return "F";
        }
    }

    boolean isPassed() {
        return score >= 60;
    }

    public static int getTotalCount() {
        return totalCount;
    }

}
