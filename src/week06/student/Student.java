package week06.student;

public class Student {
    private String name;
    private int score;
    // 총 생성된 학생 수 추적을 위한 static 변수
    private static int totalStudents = 0;

    // 1. 이름과 점수 지정
    public Student(String name, int score) {
        this.name = name;
        setScore(score); // 검증 로직 통과
        totalStudents++;
    }

    // 2. 이름만 지정
    public Student(String name) {
        this(name, 0);
    }

    // 3. 아무것도 지정하지 않음
    public Student() {
        this("이름없음", 0);
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("오류: 점수는 0~100 사이여야 합니다.");
        }
    }

    // 등급 결정
    public String getGrade() {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        return "F";
    }

    // [패키지 전용] 합격 판별 기능: 접근 제어자 없음
    boolean isPass() {
        return this.score >= 60;
    }
}