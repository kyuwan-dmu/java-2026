import java.util.Scanner;

public class Task1Bonus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n 값을 입력하세요: ");
        int size = scan.nextInt();

        int[][] matrix = new int[size][size];

        // 보너스 문제 조건에 맞게 배열 채우기
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = i + j + 1;
                // n보다 커지면 다시 처음(1)으로 돌아가도록 처리
                if (value > size) {
                    value -= size;
                }
                matrix[i][j] = value;
            }
        }

        // 결과 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scan.close();
    }
}
