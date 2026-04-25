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
                    System.out.print("이름 입력 (없으면 enter): ");
                    String name = sc.nextLine();
                    if(name.isEmpty()){
                        name = "이름없음";
                    }
                    System.out.print("점수 입력 (없으면 enter): ");
                    int score = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(name, score);
                    students[count] = student;
                    count ++;
                    System.out.println("등록완료:"+" "+ student.getName()+" "+ "("+ student.getScore()+ ")");
                    break;
                case 2:
                    for(int i = 0; i < count; i ++){
                        System.out.println(i + 1 +" 이름: "+students[i].getName()+", 점수: "+ students[i].getScore() +", "+ students[i].getGrade());
                    }
                case 3:
                case 5:
                    int sum = 0;
                    float avg = 0;
                    int j;
                    for(j = 1; j < count; j ++){
                        sum = students[j].getScore() + sum;
                    }
                    avg = sum / j;
                    System.out.printf("전체 평균: %.1f\n", avg);
                default:
                    System.out.println("TODO: 구현하세요");
            }
        }
    }

}
