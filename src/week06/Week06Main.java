package week06;

import java.util.Scanner;
import week06.student.Student;

public class Week06Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            System.out.println("\n===== 성적 관리 시스템 =====");
            System.out.println("1. 학생 등록"); //
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
                    break;
                case 1:
                    System.out.print("이름 입력 (없으면 Enter):");
                    String name = sc.next();

                    System.out.print("점수 입력 (없으면 Enter):");
                    int score = sc.nextInt();
                    if (score > 100 || score < 0) {
                        System.out.print("유효하지 않는 점수입니다");
                    }
                    String grade = "F";
                    if (score >= 90) {
                        grade = "A";
                    } else if (score >= 80) {
                        grade = "B";
                    } else if (score >= 70) {
                        grade = "c";
                    }
                    students[count++] = new Student(name, score, grade);

                    System.out.print("등록 완료: " + name + " " + score + " " +grade);
                    break;
                case 2:
                    for (int i = 0; i < count; i++) {
                        System.out.println("이름: " + students[i].getName() + ", 점수: " + students[i].getScore());
                    }
                    break;
                case 3:
                    System.out.print("이름 입력 (없으면 Enter):");
                    name = sc.next();
                    System.out.print("새 점수 입력:");
                    int nnum = sc.nextInt();
                    if (nnum > 100 || nnum < 0) {
                        System.out.print("유효하지 않는 점수입니다");
                    }
                    for (int i = 0; count > i; i++) {
                        if (students[i].getName().equals(name)) {
                            students[i].setScore(nnum);
                        }
                    }
                    break;
                case 4:
                    System.out.print("보너스 점수 입력:");
                    int b_score = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        students[i].setScore(students[i].getScore() + b_score);
                    }
                    System.out.print("보너스 부여 완료!");
                    break;
                case 5:
                    int total = 0;
                    for (int i = 0; i < count; i++) {
                        total = students[i].getScore() + total;
                    }
                    System.out.print("전체 평균: " + (double) total / count);
                    break;
                case 6:
                    System.out.print("총 학생 수: " + count);
                    break;
            }
        }
    }
}
