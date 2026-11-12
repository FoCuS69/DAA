public class FractionalKnapsack {

    public static void main(String[] args) {

        int[] value = {70, 90, 120};
        int[] weight = {10, 20, 30};

        int capacity = 35;

        // Sorting according to value/weight ratio
        for (int i = 0; i < value.length - 1; i++) {

            for (int j = i + 1; j < value.length; j++) {

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

        for (int i = 0; i < value.length; i++) {

            if (remaining >= weight[i]) {

                remaining -= weight[i];
                totalValue += value[i];

            } else {

                totalValue += (double) value[i] * remaining / weight[i];
                break;
            }
        }

        System.out.println("Knapsack capacity: " + capacity);
        System.out.println("Maximum value: " + totalValue);
    }
}