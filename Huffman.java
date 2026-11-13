import java.util.Scanner;
import java.util.PriorityQueue;

public class HuffmanCoding {

    static class Node {

        char ch;
        int freq;

        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static void printCodes(Node root, String code) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {

            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter character: ");
            chars[i] = sc.next().charAt(0);

            System.out.print("Enter frequency: ");
            freq[i] = sc.nextInt();
        }

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int i = 0; i < n; i++) {

            pq.add(new Node(chars[i], freq[i]));
        }

        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('-', left.freq + right.freq);

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        System.out.println("Huffman Codes:");

        printCodes(pq.poll(), "");

        sc.close();
    }
}
