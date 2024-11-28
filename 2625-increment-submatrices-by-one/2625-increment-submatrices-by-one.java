class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        // Process each query to update the difference matrix
        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1];
            int row2 = query[2], col2 = query[3];
            
            diff[row1][col1] += 1;
            if (col2 + 1 < n) diff[row1][col2 + 1] -= 1;
            if (row2 + 1 < n) diff[row2 + 1][col1] -= 1;
            if (row2 + 1 < n && col2 + 1 < n) diff[row2 + 1][col2 + 1] += 1;
        }

        // Compute the prefix sum to apply the differences
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) diff[i][j] += diff[i - 1][j];
                if (j > 0) diff[i][j] += diff[i][j - 1];
                if (i > 0 && j > 0) diff[i][j] -= diff[i - 1][j - 1];
                mat[i][j] = diff[i][j];
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] queries = {{1, 1, 2, 2}, {0, 0, 1, 1}};
        int[][] result = solution.rangeAddQueries(n, queries);

        // Print the result
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}