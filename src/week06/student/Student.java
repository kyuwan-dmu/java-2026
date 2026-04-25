package week06.student;

public class Student {
    private String name;
    private int score;
    private static int totalStudentCount = 0;

    public Student(String name, int score) {
        this.name = name;
        this.score = 0; // 초기값 설정 후 setter를 통해 검증
        setScore(score);
        totalStudentCount++;
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

    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("유효하지 않은 점수입니다");
        }
    }

    public char getGrade() {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        return 'F';
    }

    public static int getTotalStudentCount() {
        return totalStudentCount;
    }

    boolean isPassed() {
        return score >= 60;
    }
}