import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            for (int j=1; j<=n; j++) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }

        System.out.println();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.printf("%d ",((i+j)%n)+1);
            }
            System.out.println();
        }
    }
}