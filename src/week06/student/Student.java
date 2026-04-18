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

    // 이름만 (점수 0)
    public Student(String name) {
        this(name, 0);
    }

    // 아무것도 지정하지 않음
    public Student() {
        this("이름없음", 0);
    }

    // Getter
    public String getName() { return name; }
    public int getScore() { return score; }

    public static int getTotalCount() { return totalCount; }

    // 점수 설정 (0~100 유효성 검사)
    public boolean setScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        }
        this.score = score;
        return true;
    }

    // 등급 반환
    public String getGrade() {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else return "F";
    }

    // 합격 여부 (패키지 내부에서만 접근 가능)
    boolean isPassed() {
        return score >= 60;
    }
}