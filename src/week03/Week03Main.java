package week03;

public class Week03Main {
    public static void main(String[] args) {
        System.out.println("[3주차] 제어문과 제어 키워드");
        System.out.println("---------------------------------");

        decideArrivalMessage(9);
        describeWeekday(3);
        printOddNumbersWithControl();
        reviewUntilGoal(3);
        findFirstCommonMultiple(4, 6);
    }

    private static void decideArrivalMessage(int arrivalHour) {
        System.out.println("# if / else if / else");
        if (arrivalHour < 8) {
            System.out.println("매우 일찍 도착했습니다.");
        } else if (arrivalHour <= 9) {
            System.out.println("수업 시간에 맞춰 도착했습니다.");
        } else {
            System.out.println("지각했습니다. 강의실로 서둘러 가세요!");
        }
        System.out.println();
    }

    private static void describeWeekday(int dayOfWeek) {
        System.out.println("# switch");
        String label = switch (dayOfWeek) {
            case 1 -> "월요일";
            case 2 -> "화요일";
            case 3 -> "수요일";
            case 4 -> "목요일";
            case 5 -> "금요일";
            case 6, 7 -> {
                yield "주말";
            }
            default -> "알 수 없는 요일";
        };
        System.out.println("오늘은 " + label + " 입니다.\n");
    }

    private static void printOddNumbersWithControl() {
        System.out.println("# for + continue + break");
        for (int number = 1; number <= 10; number++) {
            if (number % 2 == 0) {
                continue; // 짝수는 건너뛴다
            }
            if (number > 7) {
                System.out.println("7보다 큰 홀수를 만났으니 종료!");
                break; // 조건을 만족하면 루프 종료
            }
            System.out.print(number + " ");
        }
        System.out.println("\n");
    }

    private static void reviewUntilGoal(int successCountNeeded) {
        System.out.println("# while + do-while");
        int success = 0;
        int attempt = 0;
        while (success < successCountNeeded) {
            attempt++;
            boolean understood = attempt % 2 == 0; // 두 번마다 이해했다고 가정
            if (!understood) {
                System.out.println(attempt + "번째 시도: 아직 헷갈림");
                continue;
            }
            success++;
            System.out.println(attempt + "번째 시도: 이해 완료! (누적 " + success + ")");
        }

        int idx = 0;
        do {
            idx++;
            System.out.println("복습 로그 " + idx);
        } while (idx < 2);
        System.out.println();
    }

    private static void findFirstCommonMultiple(int a, int b) {
        System.out.println("# break + return 활용");
        for (int i = 1; i <= 100; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.printf("%d와 %d의 최소 공배수 후보: %d%n", a, b, i);
                return; // 메서드를 즉시 종료
            }
        }
        System.out.println("100 이하에서 공배수를 찾지 못했습니다.");
    }
}
