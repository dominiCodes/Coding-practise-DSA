class Solution {
    
    // Recurrsion
    // This is a reccursive solution and will give TLE with reccursive solution, try these with DP
    // public int uniquePaths(int m, int n) {
    //     return f(m, n, m-1, n-1);
    //     }

    // public int f(int m, int n, int r, int c){
    //     if(r == 0 || c == 0){
    //         return 1;
    //     }
    //     if(r < 0 || c < 0){
    //         return 0;
    //     }
           
    //     int up= f(m, n, r-1, c);
    //     int left= f(m, n, r, c-1);
    //     return up + left;  
    // }

    
    // Memoization
    // public int uniquePaths(int m, int n) {
    //     int[][] dp= new int[m+1][n+1];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1); // Initialize each cell of the array individually
    //     }
    //     return f(m, n, m-1, n-1, dp);
    //     }

    // public int f(int m, int n, int r, int c, int[][] dp){
    //     if(r == 0 || c == 0){
    //         return 1;
    //     }
    //     if(r < 0 || c < 0){
    //         return 0;
    //     }

    //     if(dp[r][c] != -1){
    //         return dp[r][c];
    //     }
    //     int up= f(m, n, r-1, c, dp);
    //     int left= f(m, n, r, c-1, dp);
    //     return dp[r][c]= up + left;
    // }


    // Tabulation
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m+1][n+1];
        dp[0][0]= 1;

        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(i==0 && j==0) continue;
                int up= 0;
                int left=0;
                if(i>0) up= dp[i-1][j];
                if(j>0) left= dp[i][j-1];
                dp[i][j]= up + left;            
            }
        }
        return dp[m-1][n-1];
   }
}
