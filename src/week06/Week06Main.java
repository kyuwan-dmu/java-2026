package week06;

import java.util.Scanner;
import week06.student.Student;
import week06.components.*;


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
                    RegistrationStudents.registStudent(sc);
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("TODO: 구현하세요");
            }
        }
    }

}
