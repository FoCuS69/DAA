import java.util.Scanner;

public class FibonacciRecursive {

    static int count = 0;

    static int fib(int n) {
        count++;

        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive number.");
            return;
        }

        System.out.println("Fibonacci series:");

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }

        System.out.println();
        System.out.println("Total recursive calls: " + count);
    }
}