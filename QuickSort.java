import java.util.Scanner;

public class FractionalKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sorting according to value/weight ratio
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                double r1 = (double) value[i] / weight[i];
                double r2 = (double) value[j] / weight[j];

                if (r2 > r1) {

                    int temp = value[i];
                    value[i] = value[j];
                    value[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;
                }
            }
        }

        double totalValue = 0;
        int remaining = capacity;

        for (int i = 0; i < n; i++) {

            if (remaining >= weight[i]) {

                remaining -= weight[i];
                totalValue += value[i];

            } else {

                totalValue += (double) value[i] * remaining / weight[i];
                break;
            }
        }

        System.out.println("Maximum value: " + totalValue);

        sc.close();
    }
}
