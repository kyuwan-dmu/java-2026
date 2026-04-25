package week06;

import java.util.Scanner;
import week06.student.Student;
import week06.report.ReportService;

public class Week06Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
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

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    System.out.print("이름 입력 (없으면 Enter): ");
                    String name = sc.nextLine();
                    System.out.print("점수 입력 (없으면 Enter): ");
                    String scoreInput = sc.nextLine();

                    if (name.isEmpty() && scoreInput.isEmpty()) {
                        students[count] = new Student();
                    } else if (scoreInput.isEmpty()) {
                        students[count] = new Student(name);
                    } else {
                        int score = Integer.parseInt(scoreInput);
                        students[count] = new Student(name, score);
                    }
                    System.out.printf("등록 완료: %s (%d점)\n", students[count].getName(), students[count].getScore());
                    count++;
                    break;
                case 2:
                    ReportService.printAllStudents(students, count);
                    break;
                case 3:
                    System.out.print("이름 입력: ");
                    String targetName = sc.nextLine();
                    System.out.print("새 점수 입력: ");
                    int newScore = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].getName().equals(targetName)) {
                            int oldScore = students[i].getScore();
                            students[i].setScore(newScore);
                            // 점수가 성공적으로 변경되었거나 원래 유효한 점수였다면 출력
                            if (newScore >= 0 && newScore <= 100) {
                                System.out.printf("점수 수정 완료: %s (%d점)\n", students[i].getName(), students[i].getScore());
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
                    }
                    break;
                case 4:
                    System.out.print("보너스 점수 입력: ");
                    int bonus = sc.nextInt();
                    sc.nextLine();
                    ReportService.applyBonus(students, count, bonus);
                    break;
                case 5:
                    double avg = ReportService.calculateAverage(students, count);
                    System.out.printf("전체 평균: %.1f\n", avg);
                    break;
                case 6:
                    System.out.printf("총 학생 수: %d\n", Student.getTotalStudentCount());
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }
}