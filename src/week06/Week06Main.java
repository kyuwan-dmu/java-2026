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
            sc.nextLine();

            switch (menu) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.print("이름 입력 (없으면 Enter): ");
                    String name = sc.nextLine();
                    System.out.print("점수 입력 (없으면 Enter): ");
                    String scoreStr = sc.nextLine();

                    int scoreInput;
                    if (scoreStr.isEmpty()) {
                        scoreInput = 0;
                    } else {
                        scoreInput = Integer.parseInt(scoreStr);
                    }

                    if (name.isEmpty() && scoreInput == 0) {
                        students[count] = new Student();
                    } else if (scoreInput == 0) {
                        students[count] = new Student(name);
                    } else {
                        students[count] = new Student(name, scoreInput);
                    }
                    System.out.printf("등록 완료: " + students[count].getName() + " (" + students[count].getScore() + "점)");
                    count++;
                    break;
                case 2:
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("이름: " + students[i].getName() +
                                    ", 점수: " + students[i].getScore() +
                                    ", 등급: " + students[i].getGrade());
                        }
                    }
                    break;
                case 3:
                    System.out.print("이름 입력: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].getName().equals(searchName)) {
                            System.out.print("새 점수 입력: ");
                            int newScore = Integer.parseInt(sc.nextLine());

                            int beforeScore = students[i].getScore();
                            students[i].setScore(newScore);

                            if (students[i].getScore() == newScore) {
                                System.out.println("점수 수정 완료: " + searchName + " (" + newScore + "점)");
                            } else {
                                System.out.println("유효하지 않은 점수입니다");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("학생을 찾을 수 없습니다.");
                    break;

                case 4:
                    System.out.print("보너스 점수 입력: ");
                    int bonus = Integer.parseInt(sc.nextLine());
                    ReportService.addBonus(students, bonus);
                    System.out.println("보너스 부여 완료!");
                    break;

                case 5:
                    double avg = ReportService.average(students);
                    if (count == 0) {
                        System.out.println("등록된 학생이 없어 평균을 구할 수 없습니다.");
                    }
                    System.out.println("전체 평균: " + avg);
                    break;
                case 6:
                    System.out.println("총 학생 수: " + Student.getCountStud());
                    break;
                default:
                    System.out.println("TODO: 구현하세요");
            }
        }
    }

}
