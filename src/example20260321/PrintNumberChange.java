package example20260321;

import java.util.Scanner;

public class PrintNumberChange {

    public static void main(String[] args) {
        Scanner input_value = new Scanner(System.in);
        int n = input_value.nextInt();
        input_value.close();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (i + j) % n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
