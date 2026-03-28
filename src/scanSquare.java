import java.util.Scanner;

public class scanSquare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int getNumeric = scan.nextInt();

        for (int i=1; i <= getNumeric; i++){
            System.out.println();
            for (int j=1; j<=getNumeric; j++){
                System.out.print(j + " ");
             }

        }
    }
}