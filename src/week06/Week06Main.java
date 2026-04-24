package week06;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import week06.student.Student;
import week06.report.ReportService;

public class Week06Main {

    static Student[] students = new Student[100];
    static Map<String, Integer> idxMap = new HashMap<>();
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                case 1: {
                    System.out.println("이름 입력 (없으면 Enter): ");
                    String name = sc.next();
                    System.out.println("점수 입력 (없으면 Enter): ");
                    int score = sc.nextInt();

                    createStudent(name, score);
                    break;
                }
                case 2: {
                    printAllStudentInfo();
                    break;
                }
                case 3: {
                    System.out.println("이름 입력: ");
                    String name = sc.next();
                    System.out.println("새 점수 입력: ");
                    int score = sc.nextInt();

                    updateScore(name, score);
                    break;
                }
                case 4: {
                    System.out.println("보너스 점수 입력: ");
                    int bonusScore = sc.nextInt();

                    updateAllStudentBonusScore(bonusScore);
                    break;
                }
                case 5: {
                    getAllStudentAvg();
                    break;
                }
                case 6: {
                    getAllStudentCnt();
                    break;
                }
                default:
                    System.out.println("유효한 작업을 진행해주세요");
            }
        }
    }

    static private void createStudent(String name, int score) {
        students[idx] = new Student(name, score);
        idxMap.put(name, idx);
        idx++;

        System.out.printf("""
        등록 완료: %s (%d점) \n
        """, name, score);
    }

    static private void printAllStudentInfo() {
        ReportService.printAllStudentInfo(students);
    }

    static private void updateScore(String name, int score) {
        try {
            int idx = idxMap.get(name);
            students[idx].setScore(score);

            System.out.printf("""
                점수 수정 완료: %s (%d점) \n
            """, name, score);
        } catch (NullPointerException e) {
            System.out.println("정확한 학생의 이름을 적어주세요.");
        }
    }

    static private void updateAllStudentBonusScore(int bonusScore) {
        students = ReportService.allStudentBounsScore(students, bonusScore);

        System.out.println("""
        보너스 부여 완료!
        """);
    }

    static private void getAllStudentAvg() {
        double allStudentAvgScore = ReportService.allStudentAvg(students);

        System.out.printf("전체 평균: %f \n", allStudentAvgScore);
    }

    static private void getAllStudentCnt() {
        int cnt = idx;

        System.out.printf("총 학생 수: %d \n", cnt);
    }

}
