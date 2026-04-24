package week06.student;

public class Student {
    // 외부에서 직접 접근하지 못하도록 private으로 숨긴다.
    private String name;
    private int score;
    private String grade;

    // "생성된" 학생 수를 추적하는 정적 변수
    // 과제 요구사항이 등록 수가 아니라 생성 수 추적이므로 static 필드로 관리한다.
    private static int count = 0;

    // 아무것도 주지 않으면 이름없음, 0점으로 생성
    public Student() {
        this("이름없음", 0);
    }

    // 이름만 주면 점수는 0점으로 생성
    public Student(String name) {
        this(name, 0);
    }

    // 이름과 점수를 모두 받는 생성자
    public Student(String name, int score) {
        // 이름이 null이거나 공백이면 기본 이름으로 처리
        this.name = isBlank(name) ? "이름없음" : name;

        // 점수 검증은 setScore에 맡겨 중복 코드를 줄인다.
        // 요구사항상 범위를 벗어나면 거부해야 하므로 예외를 발생시킨다.
        if (!setScore(score)) {
            throw new IllegalArgumentException("유효하지 않은 점수입니다");
        }

        // 정상적으로 학생 객체가 생성된 경우에만 count 증가
        count++;
    }

    // 이름 조회
    public String getName() {
        return name;
    }

    // 점수 조회
    public int getScore() {
        return score;
    }

    // 등급 조회
    public String getGrade() {
        return grade;
    }

    // 점수를 수정하는 메서드
    // 0~100 범위가 아니면 수정하지 않고 false를 반환한다.
    public boolean setScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        }

        this.score = score;
        this.grade = calculateGrade(score);
        return true;
    }

    // 점수에 따라 등급을 계산하는 내부 전용 메서드
    private String calculateGrade(int score) {
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

    // 지금까지 생성된 총 학생 수 반환
    public static int getCount() {
        return count;
    }

    // 합격 여부 판단 메서드
    // 접근제어자를 쓰지 않아 같은 패키지 내부에서만 사용 가능하다.
    boolean isPassed() {
        return score >= 60;
    }

    // 문자열이 비어 있는지 확인하는 보조 메서드
    private boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }
}
