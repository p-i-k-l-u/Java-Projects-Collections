public class NQueens {
    public static void main(String[] args) {
        int n = 8; // Change 'n' to the desired board size
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        int[] board = new int[n];
        placeQueens(board, 0, n);
    }

    public static void placeQueens(int[] board, int row, int n) {
        if (row == n) {
            printSolution(board);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                placeQueens(board, row + 1, n);
            }
        }
    }

    public static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
