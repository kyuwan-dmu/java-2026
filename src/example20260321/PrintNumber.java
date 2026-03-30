package example20260321;

import java.util.Scanner;

public class PrintNumber {

    public static void main(String[] args) {

        Scanner input_value = new Scanner(System.in);

        int n = input_value.nextInt();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

}
