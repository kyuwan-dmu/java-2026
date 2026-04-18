package week06.student;

public class Student {
    // 1. 필드 (변수들)
    private String name;
    private int score;
    private String grade;
    private static int count = 0; // 전체 학생 수 카운트

    // 2. 생성자 (여기서부터는 클래스 안으로 쏙 들어와야 합니다!)

    // [방식 1] 이름과 점수를 모두 지정할 때
    public Student(String name, int score) {
        this.name = name;
        setScore(score); // 점수 검증 로직 호출
        count++;         // 학생 생성 시 카운트 증가
    }

    // [방식 2] 이름만 지정할 때
    public Student(String name) {
        this(name, 0);   // [방식 1] 생성자를 호출
    }

    // [방식 3] 아무것도 지정하지 않을 때
    public Student() {
        this("이름없음", 0); // [방식 1] 생성자를 호출
    }

    // 3. 메서드 (기능들)

    // 점수를 세팅하고 등급을 계산하는 메서드
    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
            calculateGrade(); // 점수가 정상일 때만 등급 계산
        } else {
            // 메인에서 "유효하지 않은 점수입니다"를 출력하겠지만,
            // 안전을 위해 여기서도 체크할 수 있습니다.
            System.out.println("유효하지 않은 점수입니다");
        }
    }

    // 등급 계산 로직 (내부에서만 사용하므로 private)
    private void calculateGrade() {
        if (score >= 90) grade = "A";
        else if (score >= 80) grade = "B";
        else if (score >= 70) grade = "C";
        else grade = "F";
    }

    // 외부에서 값을 읽어가기 위한 Getter들
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getGrade() { return grade; }

    // 총 학생 수를 반환하는 static 메서드
    public static int getCount() {
        return count;
    }

    // [중요 요구사항] 같은 패키지 내에서만 접근 가능한 합격 판별
    boolean isPassed() {
        return score >= 60;
    }
} // <--- 클래스가 여기서 닫혀야 합니다!