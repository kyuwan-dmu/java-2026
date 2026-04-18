package week06;

import java.util.Scanner;
import week06.student.Student;
import week06.report.ReportService;

public class Week06Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        String name_tmp;
        int score_tmp;
        int count = 0;

        while (true) {
            name_tmp = "";
            score_tmp = 0;
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
                    name_tmp = sc.nextLine().trim();
                    System.out.print("점수 입력 (없으면 Enter): ");
                    score_tmp = sc.nextInt();
                    students[count] = new Student(name_tmp, score_tmp);
                    System.out.println("등록 완료: " + students[count].getName() + " (" + students[count].getScore() + "점)");
                    // System.out.println("test" + students[count].getName() + students[count].getScore());
                    // text code
                    ++count;
                    break;
                case 2:
                    System.out.println("\n===== 전체 학생 목록 =====");
                    for(int i = 0; i < count; i++) {
                        System.out.println(students[i].getName() + " (" + students[i].getScore() + "점)");
                    }
                    System.out.println("========================");
                    break;
                case 3:
                    boolean yesorno = true;
                    while(yesorno) {
                        System.out.print("이름 입력: ");
                        name_tmp = sc.nextLine().trim();

                    }
                    System.out.print("이름 입력: ");
                default:
                    System.out.println("TODO: 구현하세요");
            }
        }
    }

}
