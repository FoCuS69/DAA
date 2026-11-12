import java.util.Scanner;

public class FibonacciIterative {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        int first = 0, second = 1, count = 0;

        if (n <= 0) {
            System.out.println("Enter a positive number.");
        } 
        else {
            System.out.println("Fibonacci series:");

            for (int i = 0; i < n; i++) {

                System.out.print(first + " ");

                int next = first + second;

                first = second;
                second = next;

                count++;
            }

            System.out.println();
        }

        System.out.println("Loop iterations: " + count);
    }
}