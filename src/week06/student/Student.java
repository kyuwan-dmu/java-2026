package week06.student;

public class Student {

    // TODO: 필드를 선언하세요
    private String name;
    private int score;

    // TODO: 생성자를 만드세요

    /// 아무것도 입력하지 않았다면 name(이름)은 이름없음, score(점수)는 0으로 초기화됩니다.
    public Student() {
        this.name = "이름없음";
    }

    /// 이름만 입력한다면 score(점수)는 0으로 초기화됩니다.
    public Student(String name) {
        this.name = name;
    }

    /// 이름과 점수를 입력하여 학생의 데이터(name, score)를 초기화할 수 있습니다.
    public Student(String name, int score) {
        this.name = name;
        if (score < 0 || score > 100) {
            System.out.println("유효하지 않은 점수입니다");
        }
        this.score = score;
    }

    // TODO: 메서드를 만드세요


    /// 현재 학생의 이름(name)을 반환합니다.
    public String getName() {
        return name;
    }

    /// 현재 학생의 점수(score)를 반환합니다.
    public int getScore() {
        return score;
    }

    /// 학생의 점수(score)를 수정합니다.
    public void setScore(int score) {
        if (score < 0) {
            System.out.println("유효하지 않은 점수입니다");
            this.score = 0;

            return;
        }
        if (score > 100) {
            System.out.println("유효하지 않은 점수입니다");
            this.score = 100;

            return;
        }
        this.score = score;
    }

    /// 현재 학생의 합격여부(score >= 60)를 반환합니다.
    boolean checkScore() {
        return this.score >= 60;
    }

    /// 점수별 등급을 반환합니다.
    /// 90 : A, 80 : B, 70 : C, 나머지 : F
    public String getGrade() {

        if (this.score >= 90) {
            return "A";
        } else if (this.score >= 80) {
            return "B";
        } else if (this.score >= 70) {
            return "C";
        } else {
            return "F";
        }
    }

    /// 학생의 정보를 출력합니다.
    public void printStudentInfo() {
        System.out.printf("이름: %s, 점수: %d, 등급: %s \n", this.name, this.score, getGrade());
    }



}
