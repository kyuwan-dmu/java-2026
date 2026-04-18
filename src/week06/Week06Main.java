package week06;

import java.util.Scanner;
import week06.student.Student;
import week06.report.ReportService;

public class Week06Main{

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
                    break;

                case 1:
                        System.out.print("이름 입력 (없으면 Enter): ");
                        String name = sc.nextLine();
                        if(name.isEmpty()) {
                            name = "이름없음";
                        }

                        System.out.print("점수 입력 (없으면 Enter): ");
                        String score = sc.next();

                        if(score.isEmpty()) {
                            score = "0";
                        }

                        if(Integer.parseInt(score) > 100 || Integer.parseInt(score) < 0) {
                            System.out.println("0~100점 사이로 입력해주세요.");
                            break;
                        }

                        students[count++] = new Student(name, Integer.parseInt(score));

                        System.out.println("등록완료: " + name +"("+score+"점)");
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        System.out.println("이름: " + students[i].getName()+", 점수: " + students[i].getScore()+", 등급: " + students[i].getRank());
                    }
                    break;

                case 3:
                    System.out.print("이름 입력: ");
                    name = sc.next();
                    System.out.println("새 점수 입력: ");
                    int num = sc.nextInt();

                    if(num > 100 || num < 0) {
                        System.out.println("유효하지 않은 점수입니다.");
                        break;
                    }

                    for (int i = 0; i < count; i++) {
                        if (students[i].getName().equals(name)) {
                            students[i].ResetScore(num);
                        }
                    }

                    System.out.println("점수 수정 완료: " + name+" ("+num+"점)");

                    break;
                case 4:
                    System.out.println("보너스 점수 입력:");
                    num = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        students[i].AddScore(num);
                    }

                    System.out.println("보너스 부여 완료!");
                    break;

                case 5:
                    int allScore = 0;
                    for (int i = 0; i < count; i++) {
                        allScore += students[i].getScore();
                    }

                    System.out.println("전체 평균: "+allScore/count);
                    break;
                case 6:
                    System.out.println("총 학생 수: " + (count));
            }
        }
    }

}
