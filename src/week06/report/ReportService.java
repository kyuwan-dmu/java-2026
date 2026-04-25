package week06.report;

import week06.student.Student;

public class ReportService {

    public static double calculateAverage(Student s1, Student s2) {
        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    public static double calculateAverage(Student[] students, int count) {
        if (count == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getScore();
        }
        return (double) sum / count;
    }

    public static void applyBonus(Student[] students, int count, int bonus) {
        for (int i = 0; i < count; i++) {
            int currentScore = students[i].getScore();
            students[i].setScore(currentScore + bonus);
        }
        System.out.println("보너스 부여 완료!");
    }

    public static void printAllStudents(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            System.out.printf("이름: %s, 점수: %d, 등급: %c\n",
                    students[i].getName(), students[i].getScore(), students[i].getGrade());
        }
    }
}