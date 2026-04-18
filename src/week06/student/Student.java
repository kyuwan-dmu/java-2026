package week06.student;

public class Student {

    private String name;
    private int score;
    private static int totalCount = 0;

    // 이름 + 점수
    public Student(String name, int score) {
        this.name = name;
        setScore(score);
        totalCount++;
    }

    // 이름만 (점수는 0)
    public Student(String name) {
        this(name, 0);
    }

    // 아무것도 지정하지 않음
    public Student() {
        this("이름없음", 0);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // 유효하지 않은 점수는 거부 (false 반환)
    public boolean setScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        }
        this.score = score;
        return true;
    }

    public String getGrade() {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        return "F";
    }

    // 같은 패키지(week06.student)에서만 접근 가능
    boolean isPassed() {
        return score >= 60;
    }

    public static int getTotalCount() {
        return totalCount;
    }
}
