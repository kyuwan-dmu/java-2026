package week06AI;

import java.util.Locale;
import java.util.Scanner;
import week06AI.report.ReportService;
import week06AI.student.Student;

public class Week06Main {

    private static final int MAX_STUDENTS = 100;
    private static final String MSG_NO_STUDENTS = "등록된 학생이 없습니다.";
    private static final String MSG_SCORE_NOT_INT = "점수는 정수로 입력해 주세요.";
    private static final String MSG_INVALID_SCORE = "유효하지 않은 점수입니다";
    private static final String MSG_STUDENT_NOT_FOUND = "해당 이름의 학생을 찾을 수 없습니다.";
    private static final String MSG_ARRAY_FULL = "더 이상 등록할 수 없습니다.";
    private static final String MSG_BAD_MENU = "잘못된 선택입니다.";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Student[] students = new Student[MAX_STUDENTS];
            int count = 0;

            while (true) {
                printMenu();
                int menu = sc.nextInt();
                sc.nextLine();

                if (menu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                if (menu == 1) {
                    count = registerStudent(sc, students, count);
                } else if (menu == 2) {
                    ReportService.printAll(students, count);
                } else if (menu == 3) {
                    updateScore(sc, students, count);
                } else if (menu == 4) {
                    applyBonusMenu(sc, students, count);
                } else if (menu == 5) {
                    double avg = ReportService.average(students, count);
                    System.out.printf(Locale.US, "전체 평균: %.1f%n", avg);
                } else if (menu == 6) {
                    System.out.println("총 학생 수: " + Student.getTotalCreated());
                } else {
                    System.out.println(MSG_BAD_MENU);
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== 성적 관리 시스템 =====");
        System.out.println("1. 학생 등록");
        System.out.println("2. 전체 학생 목록 조회");
        System.out.println("3. 학생 점수 수정");
        System.out.println("4. 보너스 점수 일괄 부여");
        System.out.println("5. 평균 점수 조회");
        System.out.println("6. 총 학생 수 조회");
        System.out.println("0. 종료");
        System.out.println("========================");
        System.out.print("선택> ");
    }

    private static boolean hasStudents(int count) {
        if (count == 0) {
            System.out.println(MSG_NO_STUDENTS);
            return false;
        }
        return true;
    }

    private static Student findStudentByName(Student[] students, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equals(name)) {
                return students[i];
            }
        }
        return null;
    }

    private static Student createStudentFromRegistrationInput(String nameLine, String scoreLine)
            throws NumberFormatException {
        String nameTrim = nameLine.trim();
        boolean nameEmpty = nameTrim.isEmpty();
        String scoreTrim = scoreLine.trim();
        boolean scoreEmpty = scoreTrim.isEmpty();

        if (nameEmpty && scoreEmpty) {
            return new Student();
        }
        if (nameEmpty == false && scoreEmpty) {
            return new Student(nameTrim);
        }

        int scoreVal = Integer.parseInt(scoreTrim);
        if (nameEmpty) {
            return new Student("이름없음", scoreVal);
        }
        return new Student(nameTrim, scoreVal);
    }

    private static int registerStudent(Scanner sc, Student[] students, int count) {
        if (count >= MAX_STUDENTS) {
            System.out.println(MSG_ARRAY_FULL);
            return count;
        }

        System.out.print("이름 입력 (없으면 Enter): ");
        String nameLine = sc.nextLine();
        System.out.print("점수 입력 (없으면 Enter): ");
        String scoreLine = sc.nextLine();

        try {
            Student s = createStudentFromRegistrationInput(nameLine, scoreLine);
            students[count] = s;
            System.out.println("등록 완료: " + s.getName() + " (" + s.getScore() + "점)");
            return count + 1;
        } catch (NumberFormatException e) {
            System.out.println(MSG_SCORE_NOT_INT);
            return count;
        } catch (IllegalArgumentException e) {
            System.out.println(MSG_INVALID_SCORE);
            return count;
        }
    }

    private static void updateScore(Scanner sc, Student[] students, int count) {
        if (hasStudents(count)) {
            System.out.print("이름 입력: ");
            String name = sc.nextLine().trim();
            System.out.print("새 점수 입력: ");
            String line = sc.nextLine().trim();

            Student found = findStudentByName(students, count, name);
            if (found == null) {
                System.out.println(MSG_STUDENT_NOT_FOUND);
                return;
            }

            try {
                int newScore = Integer.parseInt(line);
                boolean updated = found.setScore(newScore);
                if (updated) {
                    System.out.println("점수 수정 완료: " + found.getName() + " (" + found.getScore() + "점)");
                } else {
                    System.out.println(MSG_INVALID_SCORE);
                }
            } catch (NumberFormatException e) {
                System.out.println(MSG_SCORE_NOT_INT);
            }
        }
    }

    private static void applyBonusMenu(Scanner sc, Student[] students, int count) {
        if (hasStudents(count)) {
            System.out.print("보너스 점수 입력: ");
            int bonus = sc.nextInt();
            sc.nextLine();
            ReportService.applyBonus(students, count, bonus);
            System.out.println("보너스 부여 완료.");
        }
    }
}
