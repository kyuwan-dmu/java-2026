package week06;

import week06.student.Student;
import week06.report.ReportService;
import java.util.Scanner;

public class Week06Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 학생들을 저장할 배열 (최대 100명이라고 가정)
        Student[] students = new Student[100];
        int studentCount = 0;

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

            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1: // 학생 등록
                    System.out.print("이름 입력 (없으면 Enter): ");
                    String name = sc.nextLine();
                    System.out.print("점수 입력 (없으면 Enter): ");
                    String scoreInput = sc.nextLine();

                    Student newStudent;
                    if (name.isEmpty() && scoreInput.isEmpty()) {
                        newStudent = new Student();
                    } else if (scoreInput.isEmpty()) {
                        newStudent = new Student(name);
                    } else {
                        newStudent = new Student(name, Integer.parseInt(scoreInput));
                    }

                    students[studentCount++] = newStudent;
                    System.out.println("등록 완료: " + newStudent.getName() + " (" + newStudent.getScore() + "점)");
                    break;

                case 2: // 목록 조회
                    // 현재까지 등록된 학생들만 배열로 추려서 전달
                    ReportService.printAllStudents(getCurrentStudents(students, studentCount));
                    break;

                case 3: // 점수 수정
                    System.out.print("이름 입력: ");
                    String searchName = sc.nextLine();
                    System.out.print("새 점수 입력: ");
                    int newScore = Integer.parseInt(sc.nextLine());

                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getName().equals(searchName)) {
                            students[i].setScore(newScore);
                            if (students[i].getScore() == newScore) { // 수정 성공 시
                                System.out.println("점수 수정 완료: " + searchName + " (" + newScore + "점)");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("해당 학생을 찾을 수 없습니다.");
                    break;

                case 4: // 보너스 부여
                    System.out.print("보너스 점수 입력: ");
                    int bonus = Integer.parseInt(sc.nextLine());
                    ReportService.applyBonus(getCurrentStudents(students, studentCount), bonus);
                    System.out.println("보너스 부여 완료!");
                    break;

                case 5: // 평균 조회
                    double avg = ReportService.calculateAverage(getCurrentStudents(students, studentCount));
                    System.out.println("전체 평균: " + avg);
                    break;

                case 6: // 총 학생 수
                    System.out.println("총 학생 수: " + Student.getCount());
                    break;
            }
        }
    }

    // 현재까지 등록된 학생들만 따로 배열로 만들어주는 도우미 메서드
    private static Student[] getCurrentStudents(Student[] all, int count) {
        Student[] current = new Student[count];
        System.arraycopy(all, 0, current, 0, count);
        return current;
    }
}