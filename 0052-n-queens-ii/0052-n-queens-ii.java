class Solution {

    // \U0001f6e1️ Check if it's safe to place a queen at (row, col)
    private boolean isSafe(int row, int col, int n, char[][] board) {
        // ⬅️ Check row
        for (int c = 0; c < col; c++)
            if (board[row][c] == 'Q') return false;

        // ↖️ Check upper-left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--)
            if (board[r][c] == 'Q') return false;

        // ↙️ Check lower-left diagonal
        for (int r = row, c = col; r < n && c >= 0; r++, c--)
            if (board[r][c] == 'Q') return false;

        return true;
    }

    // \U0001f501 Try placing queens column by column
    private void backtrack(int col, int n, char[][] board, int[] count) {
        if (col == n) {
            count[0]++;  // \U0001f389 Found a valid way!
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';      // \U0001f451 Place the queen
                backtrack(col + 1, n, board, count);
                board[row][col] = '.';      // ↩️ Remove (backtrack)
            }
        }
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        int[] count = new int[1];  // \U0001f9ee Mutable counter
        backtrack(0, n, board, count);
        return count[0];
    }
}