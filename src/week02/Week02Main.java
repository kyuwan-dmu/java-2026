package week02;

public class Week02Main {
    public static void main(String[] args) {
        System.out.println("[2주차] 자료형과 연산자");
        System.out.println("------------------------------");

        printPrimitiveSamples();
        demonstrateCasting();
        demonstrateOperators();
    }

    private static void printPrimitiveSamples() {
        byte age = 20;
        short studentCount = 32;
        int year = 2026;
        long population = 7_900_000_000L;
        float height = 172.3f;
        double weight = 65.7;
        char grade = 'A';
        boolean isRegistered = true;

        System.out.println("# 기본 자료형 값");
        System.out.printf("byte:%d, short:%d, int:%d, long:%d%n", age, studentCount, year, population);
        System.out.printf("float:%.1f, double:%.1f%n", height, weight);
        System.out.printf("char:%c (%d), boolean:%b%n%n", grade, (int) grade, isRegistered);
    }

    private static void demonstrateCasting() {
        int score = 95;
        double converted = score; // 자동 형 변환
        int truncated = (int) 87.9; // 명시적 형 변환
        byte overflowed = (byte) 130; // 오버플로 확인

        System.out.println("# 형 변환");
        System.out.printf("int -> double: %.1f%n", converted);
        System.out.printf("double -> int: %d%n", truncated);
        System.out.printf("byte overflow (130 -> %d)%n%n", overflowed);
    }

    private static void demonstrateOperators() {
        int a = 7;
        int b = 3;

        System.out.println("# 산술 / 대입 / 증감");
        System.out.printf("%d + %d = %d%n", a, b, a + b);
        System.out.printf("%d %% %d = %d%n", a, b, a % b);
        int temp = a;
        temp += b;
        System.out.printf("a += b -> %d%n", temp);
        System.out.printf("전위 ++a = %d, 후위 b++ = %d (이후 %d) %n%n", ++a, b++, b);

        System.out.println("# 비교 / 논리");
        boolean isGreater = (a > b);
        boolean isEven = (a % 2 == 0);
        System.out.printf("a > b ? %b%n", isGreater);
        System.out.printf("a가 짝수이고 b가 홀수인가? %b%n", isEven && (b % 2 != 0));
        System.out.printf("a가 5보다 작거나 b가 5보다 큰가? %b%n%n", (a < 5) || (b > 5));

        System.out.println("# 삼항 연산자");
        String passOrFail = scoreResult(82);
        System.out.printf("82점은 %s%n", passOrFail);
    }

    private static String scoreResult(int score) {
        return score >= 60 ? "통과" : "재도전";
    }
}
