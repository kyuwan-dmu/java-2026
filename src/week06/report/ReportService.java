package week06.report;

import week06.student.Student;

public class ReportService {

    // 학생 2명의 평균 점수
    public static double getAverage(Student s1, Student s2) {
        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    // 학생 배열의 평균 점수
    public static double getAverage(Student[] students, int count) {
        if (count == 0) return 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getScore();
        }
        return sum / (double) count;
    }

    // 보너스 점수 일괄 부여
    public static void addBonus(Student[] students, int count, int bonus) {
        for (int i = 0; i < count; i++) {
            int newScore = students[i].getScore() + bonus;
            // 100 초과 시 100으로 제한
            students[i].setScore(Math.min(newScore, 100));
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