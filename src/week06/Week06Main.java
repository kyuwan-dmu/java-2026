package week06;

import week06.report.ReportService;
import week06.student.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Week06Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

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
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": {
                    System.out.print("이름 입력 (없으면 Enter): ");
                    String name = scanner.nextLine();
                    System.out.print("점수 입력 (없으면 Enter): ");
                    String scoreInput = scanner.nextLine();

                    Student student;
                    if (name.isEmpty() && scoreInput.isEmpty()) {
                        student = new Student();
                    } else if (scoreInput.isEmpty()) {
                        student = new Student(name);
                    } else {
                        student = new Student(name.isEmpty() ? "이름없음" : name, Integer.parseInt(scoreInput));
                    }
                    list.add(student);
                    System.out.println("등록 완료: " + student.getName() + " (" + student.getScore() + "점)");
                    break;
                }
                case "2": {
                    Student[] arr = list.toArray(new Student[0]);
                    ReportService.printAll(arr);
                    break;
                }
                case "3": {
                    System.out.print("이름 입력: ");
                    String name = scanner.nextLine();
                    Student found = null;
                    for (Student s : list) {
                        if (s.getName().equals(name)) {
                            found = s;
                            break;
                        }
                    }
                    if (found == null) {
                        System.out.println("해당 학생을 찾을 수 없습니다.");
                        break;
                    }
                    System.out.print("새 점수 입력: ");
                    int newScore = Integer.parseInt(scanner.nextLine());
                    if (!found.setScore(newScore)) {
                        System.out.println("유효하지 않은 점수입니다");
                    } else {
                        System.out.println("점수 수정 완료: " + found.getName() + " (" + found.getScore() + "점)");
                    }
                    break;
                }
                case "4": {
                    System.out.print("보너스 점수 입력: ");
                    int bonus = Integer.parseInt(scanner.nextLine());
                    Student[] arr = list.toArray(new Student[0]);
                    ReportService.applyBonus(arr, bonus);
                    System.out.println("보너스 부여 완료!");
                    break;
                }
                case "5": {
                    Student[] arr = list.toArray(new Student[0]);
                    System.out.println("전체 평균: " + ReportService.average(arr));
                    break;
                }
                case "6": {
                    System.out.println("총 학생 수: " + Student.getTotalCount());
                    break;
                }
                case "0": {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }
}
