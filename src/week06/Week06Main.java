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
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("점수: ");
                    String scoreInput = sc.nextLine();

                    Student newStudent;
                    if (name.isEmpty() && scoreInput.isEmpty()) {
                        newStudent = new Student(); // 이름없음, 0점
                    } else if (scoreInput.isEmpty()) {
                        newStudent = new Student(name); // 이름 지정, 0점
                    } else {
                        int score = Integer.parseInt(scoreInput);
                        newStudent = new Student(name, score); // 이름, 점수 지정
                    }
                    // 새로운 학생 객체 생성 후 배열에 저장
                    students[count++] = newStudent;
                    System.out.println("등록 완료");
                    break;

                case 2:
                    System.out.println("--- 전체 학생 목록 ---");
                    for (int i = 0; i < count; i++) {
                        System.out.println(students[i].getName() + ": " + students[i].getScore());
                    }
                    break;

                case 3:
                    System.out.print("수정할 학생 이름: ");
                    String targetName = sc.nextLine();
                    for (int i = 0; i < count; i++) {
                        if (students[i].getName().equals(targetName)) {
                            System.out.print("새로운 점수: ");
                            int newScore = sc.nextInt();
                            students[i].setScore(newScore);
                            System.out.println("수정 완료");
                        }
                    }
                    break;

                case 4:
                    System.out.print("부여할 보너스 점수: ");
                    int bonus = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        students[i].setScore(students[i].getScore() + bonus);
                    }
                    System.out.println("전체 학생 점수 업데이트 완료");
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        int sum = 0;
                        for (int i = 0; i < count; i++) {
                            sum += students[i].getScore();
                        }
                        System.out.println("전체 평균: " + (double) sum / count);
                    }
                    break;

                case 6:
                    System.out.println("현재 등록된 학생 수: " + count + "명");
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }
}