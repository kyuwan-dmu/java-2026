package week06;

import java.util.Scanner;
import week06.report.ReportService;
import week06.student.Student;

public class Week06Main {

    public static void main(String[] args) {
        // Scanner를 try-with-resources로 생성하면
        // 프로그램이 끝날 때 자동으로 close 되어 자원 관리가 안전하다.
        try (Scanner sc = new Scanner(System.in)) {
            Student[] students = new Student[100];
            int studentCount = 0;

            while (true) {
                printMenu();
                System.out.print("선택> ");
                String menu = sc.nextLine();

                switch (menu) {
                    case "1":
                        if (studentCount >= students.length) {
                            System.out.println("더 이상 학생을 등록할 수 없습니다.");
                            break;
                        }

                        Student newStudent = createStudentFromInput(sc);
                        students[studentCount] = newStudent;
                        studentCount++;

                        System.out.printf("등록 완료: %s (%d점)%n",
                                newStudent.getName(), newStudent.getScore());
                        break;

                    case "2":
                        ReportService.printAllStudents(students, studentCount);
                        break;

                    case "3":
                        updateStudentScore(sc, students, studentCount);
                        break;

                    case "4":
                        int bonus = readInt(sc, "보너스 점수 입력: ");
                        ReportService.applyBonus(students, studentCount, bonus);
                        System.out.println("보너스 부여 완료!");
                        break;

                    case "5":
                        System.out.println("전체 평균: "
                                + ReportService.calculateAverage(students, studentCount));
                        break;

                    case "6":
                        System.out.println("총 학생 수: " + Student.getCount());
                        break;

                    case "0":
                        System.out.println("프로그램을 종료합니다.");
                        return;

                    default:
                        System.out.println("올바른 메뉴 번호를 입력해주세요.");
                }
            }
        }
    }

    // 메뉴 출력 전용 메서드
    private static void printMenu() {
        System.out.println("===== 성적 관리 시스템 =====");
        System.out.println("1. 학생 등록");
        System.out.println("2. 전체 학생 목록 조회");
        System.out.println("3. 학생 점수 수정");
        System.out.println("4. 보너스 점수 일괄 부여");
        System.out.println("5. 평균 점수 조회");
        System.out.println("6. 총 학생 수 조회");
        System.out.println("0. 종료");
        System.out.println("========================");
    }

    // 학생 등록 입력을 처리하는 메서드
    // 숫자가 아닌 점수를 입력하면 점수만 다시 입력받도록 만들어
    // 사용자가 이름을 처음부터 다시 치지 않아도 되게 했다.
    private static Student createStudentFromInput(Scanner sc) {
        System.out.print("이름 입력 (없으면 Enter): ");
        String name = sc.nextLine();

        while (true) {
            System.out.print("점수 입력 (없으면 Enter): ");
            String scoreInput = sc.nextLine();

            try {
                if (isBlank(name) && isBlank(scoreInput)) {
                    return new Student();
                } else if (isBlank(scoreInput)) {
                    return new Student(name);
                } else {
                    int score = Integer.parseInt(scoreInput);
                    return new Student(name, score);
                }
            } catch (NumberFormatException e) {
                System.out.println("점수는 숫자로 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 학생 이름을 찾아 점수를 수정하는 메서드
    private static void updateStudentScore(Scanner sc, Student[] students, int studentCount) {
        System.out.print("이름 입력: ");
        String searchName = sc.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getName().equals(searchName)) {
                while (true) {
                    try {
                        System.out.print("새 점수 입력: ");
                        int newScore = Integer.parseInt(sc.nextLine());

                        if (students[i].setScore(newScore)) {
                            System.out.printf("점수 수정 완료: %s (%d점)%n",
                                    students[i].getName(), students[i].getScore());
                        } else {
                            System.out.println("유효하지 않은 점수입니다");
                        }
                        return;
                    } catch (NumberFormatException e) {
                        System.out.println("점수는 숫자로 입력해주세요.");
                    }
                }
            }
        }

        System.out.println("학생을 찾을 수 없습니다.");
    }

    // 정수 입력을 안전하게 받을 때 사용하는 공통 메서드
    private static int readInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해주세요.");
            }
        }
    }

    // 문자열이 비어 있는지 검사하는 메서드
    private static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }
}
