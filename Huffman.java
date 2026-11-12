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

        char[] chars = {'A', 'B', 'C', 'D', 'E'};

        int[] freq = {12, 7, 20, 15, 5};

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int i = 0; i < chars.length; i++) {

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
    }
}