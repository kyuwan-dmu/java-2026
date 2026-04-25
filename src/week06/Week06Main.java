package week06;

import java.util.Arrays;
import java.util.Scanner;
import week06.report.ReportService;
import week06.student.Student;

public class Week06Main {

    private static final int MAX_STUDENT_COUNT = 100;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Student[] students = new Student[MAX_STUDENT_COUNT];
            int count = 0;
            boolean isRunning = true;

            while (isRunning) {
                printMenu();
                int menu = readMenu(sc);

                if (menu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                } else if (menu == 1) {
                    if (count >= students.length) {
                        System.out.println("학생 등록 한도를 초과했습니다.");
                        continue;
                    }
                    System.out.print("이름 입력 (없으면 Enter): ");
                    String nameInput = sc.nextLine();
                    System.out.print("점수 입력 (없으면 Enter): ");
                    String scoreInput = sc.nextLine().trim();
                    try {
                        Student newStudent;
                        if (nameInput.isBlank() && scoreInput.isEmpty()) {
                            newStudent = new Student();
                        } else if (scoreInput.isEmpty()) {
                            newStudent = new Student(nameInput);
                        } else {
                            newStudent = new Student(nameInput, Byte.parseByte(scoreInput));
                        }
                        students[count] = newStudent;
                        count++;
                        System.out.println("등록 완료: " + newStudent.getStudentName() + " (" + newStudent.getStudentScore() + "점)");
                    } catch (NumberFormatException e) {
                        System.out.println("점수는 0~100 사이의 정수로 입력해주세요.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (menu == 2) {
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        continue;
                    }
                    System.out.println(ReportService.printAllStudentsInfo(Arrays.copyOf(students, count)));
                } else if (menu == 3) {
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        continue;
                    }
                    System.out.print("이름 입력: ");
                    String targetName = sc.nextLine().trim();
                    Student found = findStudentByName(students, count, targetName);
                    if (found == null) {
                        System.out.println("해당 이름의 학생이 없습니다.");
                        continue;
                    }
                    System.out.print("새 점수 입력: ");
                    String newScoreInput = sc.nextLine().trim();
                    try {
                        found.setStudentScore(Byte.parseByte(newScoreInput));
                        System.out.println("점수 수정 완료: " + found.getStudentName() + " (" + found.getStudentScore() + "점)");
                    } catch (NumberFormatException e) {
                        System.out.println("점수는 0~100 사이의 정수로 입력해주세요.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (menu == 4) {
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                        continue;
                    }
                    System.out.print("보너스 점수 입력: ");
                    String bonusInput = sc.nextLine().trim();
                    try {
                        byte bonusScore = Byte.parseByte(bonusInput);
                        System.out.println(ReportService.addAllBonusStudentScore(Arrays.copyOf(students, count), bonusScore));
                    } catch (NumberFormatException e) {
                        System.out.println("보너스 점수는 -100~100 사이의 정수로 입력해주세요.");
                    }
                } else if (menu == 5) {
                    if (count == 0) {
                        System.out.println("전체 평균: 0.0");
                        continue;
                    }
                    try {
                        short scaled = ReportService.average(Arrays.copyOf(students, count));
                        double average = scaled / (double) ReportService.AVERAGE_SCORE_SCALE;
                        System.out.printf("전체 평균: %.1f%n", average);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (menu == 6) {
                    System.out.println("총 학생 수: " + Student.getTotalStudentCount());
                } else {
                    System.out.println("유효한 메뉴 번호를 입력해주세요.");
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

    private static int readMenu(Scanner sc) {
        String menuInput = sc.nextLine().trim();
        try {
            return Integer.parseInt(menuInput);
        } catch (NumberFormatException e) {
            System.out.println("숫자 메뉴를 입력해주세요.");
            return -1;
        }
    }

    private static Student findStudentByName(Student[] students, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentName().equals(name)) {
                return students[i];
            }
        }
        return null;
    }

    // 문자열이 비어 있는지 검사하는 메서드
    private static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }
}
