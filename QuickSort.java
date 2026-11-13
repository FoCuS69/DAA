import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSortAnalysis {

    static Random random = new Random();

    static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Partition function
    static int partition(int[] a, int low, int high) {

        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (a[j] <= pivot) {

                i++;
                swap(a, i, j);
            }
        }

        swap(a, i + 1, high);

        return i + 1;
    }

    // Deterministic Quick Sort
    static void deterministicQuickSort(int[] a, int low, int high) {

        if (low < high) {

            int p = partition(a, low, high);

            deterministicQuickSort(a, low, p - 1);
            deterministicQuickSort(a, p + 1, high);
        }
    }

    // Randomized partition
    static int randomPartition(int[] a, int low, int high) {

        int randomIndex = low + random.nextInt(high - low + 1);

        swap(a, randomIndex, high);

        return partition(a, low, high);
    }

    // Randomized Quick Sort
    static void randomizedQuickSort(int[] a, int low, int high) {

        if (low < high) {

            int p = randomPartition(a, low, high);

            randomizedQuickSort(a, low, p - 1);
            randomizedQuickSort(a, p + 1, high);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive number.");
            sc.close();
            return;
        }

        int[] original = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }

        int[] a = original.clone();
        int[] b = original.clone();

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(original));

        long start = System.nanoTime();

        deterministicQuickSort(a, 0, a.length - 1);

        long end = System.nanoTime();

        System.out.println("Deterministic Quick Sort:");
        System.out.println(Arrays.toString(a));

        System.out.println("Time: " + (end - start) + " ns");

        start = System.nanoTime();

        randomizedQuickSort(b, 0, b.length - 1);

        end = System.nanoTime();

        System.out.println("Randomized Quick Sort:");
        System.out.println(Arrays.toString(b));

        System.out.println("Time: " + (end - start) + " ns");

        sc.close();
    }
}
