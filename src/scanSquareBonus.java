import java.util.Scanner;

public class scanSquareBonus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeric = scan.nextInt();

        int[][] arr = new int[numeric][numeric];

        for (int i=0; i<numeric; i++) {
            for (int j=0; j<numeric; j++) {
                arr[i][j]=(i + j) % numeric+1;
            }
        }

        for (int i=0; i<numeric; i++) {
            for (int j=0; j<numeric; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}
