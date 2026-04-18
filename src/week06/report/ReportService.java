package week06.report;

import week06.student.Student;

public class ReportService {

    // 학생 2명의 평균
    public static double calculateAverage(Student s1, Student s2) {
        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    // 학생 배열의 평균
    public static double calculateAverage(Student[] students) {
        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return (double) sum / students.length;
    }

    // 전체 보너스 점수 부여
    public static void applyBonus(Student[] students, int bonus) {
        for (Student s : students) {
            s.setScore(s.getScore() + bonus);
        }
    }

    // 전체 정보 출력
    public static void printAllStudents(Student[] students) {
        for (Student s : students) {
            System.out.println("이름: " + s.getName() + " | 점수: " + s.getScore() + " | 등급: " + s.getGrade());
        }
    }
}