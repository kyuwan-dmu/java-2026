package week04;

import java.util.Arrays;
import java.util.List;

public class Week04Main {
    public static void main(String[] args) {
        System.out.println("[4주차] 참조 자료형");
        System.out.println("------------------------");

        demonstrateArrays();
        demonstrateStrings();
        demonstrateObjects();
    }

    private static void demonstrateArrays() {
        int[] quizScores = {85, 72, 90, 68};
        quizScores[1] = 78; // 참조형이라 같은 배열을 여러 곳에서 공유

        System.out.println("# 배열");
        System.out.println("원본: " + Arrays.toString(quizScores));

        int[] cloned = quizScores.clone();
        cloned[0] = 100;
        System.out.println("복사본 변경 후");
        System.out.println("cloned: " + Arrays.toString(cloned));
        System.out.println("quizScores: " + Arrays.toString(quizScores) + "\n");
    }

    private static void demonstrateStrings() {
        System.out.println("# 문자열과 StringBuilder");
        String greeting = "안녕하세요";
        String target = "학생 여러분";
        String sentence = greeting + ", " + target + "!";
        System.out.println(sentence);

        StringBuilder builder = new StringBuilder("오늘 학습한 것: ");
        builder.append("배열").append(", 문자열").append(", 객체");
        System.out.println(builder + "\n");
    }

    private static void demonstrateObjects() {
        System.out.println("# 사용자 정의 클래스 & List");
        List<Student> students = List.of(
                new Student("김자바", 1),
                new Student("이객체", 2)
        );

        LectureNote note = new LectureNote("참조 자료형", students);
        note.printSummary();
        System.out.println();
    }

    private static class Student {
        private final String name;
        private final int seatNumber;

        private Student(String name, int seatNumber) {
            this.name = name;
            this.seatNumber = seatNumber;
        }
    }

    private static class LectureNote {
        private final String topic;
        private final List<Student> participants;

        private LectureNote(String topic, List<Student> participants) {
            this.topic = topic;
            this.participants = participants;
        }

        private void printSummary() {
            System.out.println("강의 주제: " + topic);
            System.out.println("참여 학생 수: " + participants.size());
            System.out.println("첫 번째 학생 이름: " + participants.get(0).name);
        }
    }
}
