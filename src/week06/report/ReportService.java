package week06.report;

import week06.student.Student;

public class ReportService {

    public static double getAverage(Student a, Student b) {
        return (a.getScore() + b.getScore()) / 2.0;
    }

    public static double getAverage(Student[] students, int count) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += students[i].getScore();
        }
        return (double) total / count;
    }

    public static void addBonus(Student[] students, int count, int bonus) {
        for (int i = 0; i < count; i++) {
            int newScore = students[i].getScore() + bonus;
            if (newScore > 100) {
                newScore = 100;
            }
            students[i].setScore(newScore);
        }
    }

    public static void printAll(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("이름: " + students[i].getName() + ", 점수: " + students[i].getScore() + ", 등급: " + students[i].getGrade());
        }
    }

}
