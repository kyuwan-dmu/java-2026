package week06.report;

import week06.student.Student;

public class ReportService {

    public static double getAverage(Student s1, Student s2) {
        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    public static double getAverage(Student[] students, int count) {
        if (count == 0) return 0;
        if (count == 2) return getAverage(students[0], students[1]);
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getScore();
        }
        return sum / (double) count;
    }

    public static void addBonus(Student[] students, int count, int bonus) {
        for (int i = 0; i < count; i++) {
            int newScore = students[i].getScore() + bonus;
            if (newScore > 100) newScore = 100;
            students[i].setScore(newScore);
        }
    }

    public static void printAll(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("이름: " + students[i].getName()
                    + ", 점수: " + students[i].getScore()
                    + ", 등급: " + students[i].getGrade());
        }
    }
}
