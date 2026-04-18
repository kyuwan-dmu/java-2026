package week06.report;

import week06.student.Student;

import java.util.Arrays;
import java.util.Objects;

public class ReportService {

    // TODO: 리포트 관련 메서드를 만드세요

    /// 두 학생(Student) 데이터를 파라미터로 두 학생의 점수의 평균을 계산합니다.
    static public double studentAvg(Student student1, Student student2) {
        return student1.getScore() + (double) student2.getScore() / 2;
    }

    /// 여러 학생(Student) 데이터를 파라미터로 전체 학생의 점수의 평균을 계산합니다.
    static public double allStudentAvg(Student[] students) {
        // 평균 로직에서 배열 null 넘겨서 처리해야함
    }

    /// 학생 배열 전체에 보너스 점수 일괄 부여
    static public Student[] allStudentBounsScore(Student[] students, int score) {
        for (Student student : students) {
            if (Objects.isNull(student)) {
                break;
            }
            student.setScore(student.getScore() + score);
        }

        return students;
    }

    /// 학생 배열 전체 정보 출력
    static public void printAllStudentInfo(Student[] students) {
        for (Student student : students) {
            if (Objects.isNull(student)) {
                break;
            }
            student.printStudentInfo();
        }
    }




}
