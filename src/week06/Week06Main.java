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

                    Student s;
                    if (name.isEmpty() && scoreStr.isEmpty()) {
                        s = new Student();
                    } else if (scoreStr.isEmpty()) {
                        s = new Student(name);
                    } else {
                        int score = Integer.parseInt(scoreStr);
                        if (name.isEmpty()) {
                            s = new Student("이름없음", score);
                        } else {
                            s = new Student(name, score);
                        }
                    }
                    students[count] = s;
                    count++;
                    System.out.println("등록 완료: " + s.getName() + " (" + s.getScore() + "점)");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        ReportService.printAll(students, count);
                    }
                    break;

                case 3:
                    System.out.print("이름 입력: ");
                    String targetName = sc.nextLine();

                    Student found = null;
                    for (int i = 0; i < count; i++) {
                        if (students[i].getName().equals(targetName)) {
                            found = students[i];
                            break;
                        }
                    }

                    if (found == null) {
                        System.out.println("해당 학생을 찾을 수 없습니다.");
                        break;
                    }

                    System.out.print("새 점수 입력: ");
                    int newScore = Integer.parseInt(sc.nextLine());

                    boolean success = found.setScore(newScore);
                    if (success) {
                        System.out.println("점수 수정 완료: " + found.getName() + " (" + found.getScore() + "점)");
                    } else {
                        System.out.println("유효하지 않은 점수입니다");
                    }
                    break;

                case 4:
                    System.out.print("보너스 점수 입력: ");
                    int bonus = Integer.parseInt(sc.nextLine());
                    ReportService.addBonus(students, count, bonus);
                    System.out.println("보너스 부여 완료!");
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        double avg = ReportService.getAverage(students, count);
                        System.out.println("전체 평균: " + avg);
                    }
                    break;

                case 6:
                    System.out.println("총 학생 수: " + Student.getTotalCount());
                    break;

                default:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

}
