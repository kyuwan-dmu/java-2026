import java.util.Scanner;
public class Main {
    public static void main(String[]ar) {
        // 과제1
        Scanner sc = new Scanner(System.in);            // 값을 입력 받을 수 있게 스케너 클래스 Sacnner함수로 선언
        int n = sc.nextInt();                           // 입력받는 값을 정수형 숫자로 받기위에 int형 변수로 선언
        for (int i = 1; i <= n; i++) {                  // 반복문 입력받는 값보다 i가 커지기 전까지 반복하게 설정 ( 5를 입력시 5번 실행 출력물로 치면 세로 5줄)
            for (int k = 1; k <= n; k++) {              // 이중 포문  입력받는 값보다 k가 커지기 전까지 반복하게 설정 ( 5를 입력시 5번 실행 출력물로 치면 가로 5줄)
                System.out.print(k);                    // 숫자 1부터 5까지 출력을 위해 k를 호출

            }
            System.out.println();                       // 줄내림을 위한 빈값 출력

        }
        // 과제1 보너스
        for (int i = 1; i < n; i++) {                   // 위에 있는 반복문과 같은 구조(반복문 입력받는 값보다 i가 커지기 전까지 반복하게 설정)
            int num = i + 1;                            // 숫자를 출력해주기 위해 선언한 변수(i나 k를 써도 되지만 그렇게 되면 반복문에 방해가 되서 따로 선언함)

            for (int j = 0; j < n; j++) {               // 이중 포문(직접적으로 숫자를 출력해주는 반복문)
                System.out.print(num);                  // 위에서 선언한 num 출력
                num++;                                  // num에 1 더하기 다음에는 1 더한 2를 출력하기 위한 부분

                if (num > n) {                          // num이 n보다 클때 실행하기위한 조건문
                    num = 1;                            // num을 1로 초기화함
                }
            }
            System.out.println();                       // 줄내림을 위한 빈값 출력
        }
    }
}
