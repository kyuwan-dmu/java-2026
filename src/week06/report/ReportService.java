package week06.report;

import week06.student.Student;

public class ReportService {

    // 학생 2명의 평균
    public static double average(Student a, Student b) {
        return (a.getScore() + b.getScore()) / 2.0;
    }

    // 학생 배열의 평균 (메서드 이름 동일 → 오버로딩)
    public static double average(Student[] students, int count) {
        if (count == 0) return 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getScore();
        }
        return (double) sum / count;
    }

    // 보너스 점수 일괄 부여 (100점 초과 시 100으로 제한)
    public static void applyBonus(Student[] students, int count, int bonus) {
        for (int i = 0; i < count; i++) {
            int newScore = students[i].getScore() + bonus;
            if (newScore > 100) newScore = 100;
            students[i].setScore(newScore);
        }
    }

    // 전체 학생 정보 출력
    public static void printAll(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("이름: " + students[i].getName()
                    + ", 점수: " + students[i].getScore()
                    + ", 등급: " + students[i].getGrade());
        }
    }
}
