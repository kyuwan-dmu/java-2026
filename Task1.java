import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n 값을 입력하세요: ");
        int size = scan.nextInt();

        // 2차원 배열 세팅
        int[][] matrix = new int[size][size];

        // 배열 값 채우기
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = j + 1;
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
