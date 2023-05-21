import java.util.Scanner;

class Factorial {
    public static void main(String args[]) {
        int n, fact = 1;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.print("Factorial of " + n + " is : " + fact);

    }
}