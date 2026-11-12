public class NQueens {

    static final int N = 8;

    static boolean isSafe(int[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {

            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < N; i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solve(int[][] board, int row) {

        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solve(board, row + 1))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] board = new int[N][N];

        // Place first queen
        board[0][0] = 1;

        if (solve(board, 1)) {

            System.out.println("N-Queens Solution:");

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {

                    System.out.print(board[i][j] + " ");
                }

                System.out.println();
            }

        } else {

            System.out.println("No solution exists.");
        }
    }
}