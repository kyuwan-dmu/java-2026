package week06.report;

import week06.student.Student;

public class ReportService {

    public static double average(Student a, Student b) {
        return (a.getScore() + b.getScore()) / 2.0;
    }

    public static double average(Student[] students) {
        if (students.length == 0) return 0;
        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return sum / (double) students.length;
    }

    public static void applyBonus(Student[] students, int bonus) {
        for (Student s : students) {
            int newScore = s.getScore() + bonus;
            if (newScore > 100) newScore = 100;
            s.setScore(newScore);
        }
    }

    public static void printAll(Student[] students) {
        for (Student s : students) {
            System.out.println("이름: " + s.getName() + ", 점수: " + s.getScore() + ", 등급: " + s.getGrade());
        }
    }
}
