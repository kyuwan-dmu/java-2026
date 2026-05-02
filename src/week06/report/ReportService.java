package week06.report;

import week06.student.Student;

public class ReportService {

    // 학생 2명의 평균 점수 계산
    // null이 들어오면 0.0을 반환해 프로그램이 죽지 않도록 방어한다.
    public static double calculateAverage(Student s1, Student s2) {
        if (s1 == null || s2 == null) {
            return 0.0;
        }

        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    // 학생 배열의 평균 점수 계산
    // 배열 전체를 복사하지 않고, 실제 사용 중인 개수(count)만큼만 순회한다.
    public static double calculateAverage(Student[] students, int count) {
        if (students == null || count <= 0) {
            return 0.0;
        }

        int sum = 0;
        int validCount = 0;

        for (int i = 0; i < count; i++) {
            if (students[i] != null) {
                sum += students[i].getScore();
                validCount++;
            }
        }

        if (validCount == 0) {
            return 0.0;
        }

        return (double) sum / validCount;
    }

    // 모든 학생에게 동일한 보너스 점수를 부여
    // 단, 점수가 0~100 범위를 벗어나면 Student.setScore가 거부하므로
    // 그 학생의 점수는 그대로 유지된다.
    public static void applyBonus(Student[] students, int count, int bonus) {
        if (students == null || count <= 0) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (students[i] != null) {
                int newScore = students[i].getScore() + bonus;
                students[i].setScore(newScore);
            }
        }
    }

    // 등록된 학생 전체 정보 출력
    public static void printAllStudents(Student[] students, int count) {
        if (students == null || count <= 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (students[i] != null) {
                System.out.printf("이름: %s, 점수: %d, 등급: %s%n",
                        students[i].getName(),
                        students[i].getScore(),
                        students[i].getGrade());
            }
        }
    }
}
