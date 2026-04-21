package week06.report;

import java.util.Objects;
import week06.student.Student;

public class ReportService {

    // 평균을 float으로 담으면 32비트를 차지하니까 정수형으로 바꿔서 저장
    public static final byte AVERAGE_SCORE_SCALE = 10;

    // 얘를 쓰긴함?
    public static short average(Student s1, Student s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2)) {
            throw new IllegalArgumentException("Null인 학생 객체가 있습니다.");
        }

        int sum = s1.getStudentScore() + s2.getStudentScore();

        return (short) ((sum * AVERAGE_SCORE_SCALE) / 2);

    }

    public static short average(Student[] students) {
        if (Objects.isNull(students) || students.length == 0) {
            return 0;
        }

        long sum = 0L;
        for (int i = 0; i < students.length; i++) {
            if (Objects.isNull(students[i])) {
                throw new IllegalArgumentException("Null인 학생 객체가 있습니다.");
            }
            sum += students[i].getStudentScore();
        }

        return (short) ((sum * AVERAGE_SCORE_SCALE + students.length / 2) / students.length);

    }

    public static String addAllBonusStudentScore(Student[] students, byte bonusScore) {
        if (Objects.isNull(students)) {
            return "Null인 학생 배열이 있습니다.";
        }
        for (int i = 0; i < students.length; i++) {
            if (Objects.nonNull(students[i])) {
                students[i].addBonusStudentScore(bonusScore);
            }
        }
        return "보너스 부여 완료!";
    }

    public static String printAllStudentsInfo(Student[] students) {
        if (Objects.isNull(students)) {
            return "Null인 학생 배열이 있습니다.";
        }
        for (int i = 0; i < students.length; i++) {
            if (Objects.nonNull(students[i])) {
                System.out.println(formatStudentLine(students[i]));
            }
        }
        return "--------------------------------";
    }

    // AI가 썼던건데 좋아보여서 채택
    private static String formatStudentLine(Student s) {
        return "이름 :" + s.getStudentName() + "," + " 점수 :" + s.getStudentScore() + "," + " 등급 :" + s.getStudentGrade();
    }

}
