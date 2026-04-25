package week06.report;

import week06.student.Student;

import java.util.Objects;

public class ReportService {

    // TODO: 리포트 관련 메서드를 만드세요
    public static double average(Student s1, Student s2){
        return ((s1.getScore() + s2.getScore()) / 2.0);
    }

    public static double average(Student[] students) {
        if (students.length == 0) return 0.0;
        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return (double) sum / students.length;
    }

    public static void addBonus(Student[] students, int bonus) {
        for (Student s : students) {
            int currentScore = s.getScore();
            s.setScore(currentScore + bonus);
        }
    }

    public static void printAll(Student[] students) {
        for (Student s : students) {
            if (s != null) {
                s.getName();
                s.getScore();
                s.getGrade();
            }
        }
    }
}
