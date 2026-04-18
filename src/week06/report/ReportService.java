package week06.report;

import week06.student.Student;

public final class ReportService {

    private ReportService() {
    }

    public static double average(Student s1, Student s2) {
        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    public static double average(Student[] students, int count) {
        if (count <= 0) {
            return 0.0;
        }
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getScore();
        }
        return sum / (double) count;
    }

    public static void applyBonus(Student[] students, int count, int bonus) {
        for (int i = 0; i < count; i++) {
            students[i].addBonus(bonus);
        }
    }

    public static void printAll(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(formatStudentLine(students[i]));
        }
    }

    private static String formatStudentLine(Student s) {
        return "이름: " + s.getName() + ", 점수: " + s.getScore() + ", 등급: " + s.getGrade();
    }
}
