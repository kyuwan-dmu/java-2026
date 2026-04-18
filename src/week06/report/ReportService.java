package week06.report;

import week06.student.Student; // 다른 패키지에 있는 Student를 가져다 씁니다.

public class ReportService {

    // 1. 학생 2명의 평균 점수 계산 (static)
    public static double calculateAverage(Student s1, Student s2) {
        return (s1.getScore() + s2.getScore()) / 2.0;
    }

    // 2. 학생 배열의 평균 점수 계산 (메서드 오버로딩: 이름은 같지만 파라미터가 다름)
    public static double calculateAverage(Student[] students) {
        if (students.length == 0) return 0.0;

        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return (double) sum / students.length;
    }

    // 3. 학생 배열 전체에 보너스 점수 일괄 부여
    public static void applyBonus(Student[] students, int bonus) {
        for (Student s : students) {
            int newScore = s.getScore() + bonus;
            // 점수가 100점을 넘지 않도록 setter에서 검증하겠지만,
            // 여기선 단순히 값을 전달합니다.
            s.setScore(newScore);
        }
    }

    // 4. 학생 배열 전체 정보 출력
    public static void printAllStudents(Student[] students) {
        for (Student s : students) {
            System.out.printf("이름: %s, 점수: %d, 등급: %s%n",
                    s.getName(), s.getScore(), s.getGrade());
        }
    }
}