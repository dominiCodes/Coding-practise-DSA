class Solution {
    
    //Recurrsion
//     public int minPathSum(int[][] grid) {
//         int m= grid.length;
//         int n= grid[0].length;
//         return f(grid, m-1, n-1); 
//     }
    
    
//     public int f(int[][]grid, int r, int c){
//     if(r == 0 && c == 0){
//         return grid[r][c];
//     }
    
//     if(r < 0 || c < 0){
//         return (int) Math.pow(10, 9);
//     }
    
//     int up= f(grid, r-1, c) + grid[r][c];
//     int left= f(grid, r, c-1) + grid[r][c];;
//     return Math.min(up, left);
//     }    
    
    
    
    
    //Memoization
    // public int minPathSum(int[][] grid) {
    //     int m= grid.length;
    //     int n= grid[0].length;
    //     int dp[][]= new int[m][n];
    //     for(int[] rows : dp){
    //         Arrays.fill(rows, -1);
    //     }
    //     return f(grid, m-1, n-1, dp); 
    // }
    
    
    // public int f(int[][]grid, int r, int c, int[][] dp){
    // if(r == 0 && c == 0){
    //     return grid[r][c];
    // }
        
    // if(r < 0 || c < 0){
    //     return (int) Math.pow(10, 9);
    // }
    
    // if(dp[r][c] != -1){
    //     return dp[r][c];
    // }    
        
    // int up= f(grid, r-1, c, dp) + grid[r][c];
    // int left= f(grid, r, c-1, dp) + grid[r][c];;
    // return dp[r][c]= Math.min(up, left);
    // }   
    
    //Tabulation
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int dp[][]= new int[m][n];
        
        dp[0][0]= grid[0][0];

        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(i==0 && j==0) continue;
                int up= grid[i][j];
                int left= grid[i][j];
                if(i > 0){
                    left+= dp[i-1][j];
                }else{
                    left+= (int) Math.pow(10, 9);
                }
                if(j > 0){
                    up+= dp[i][j-1];
                }else{
                    up+= (int) Math.pow(10, 9);
                }
                dp[i][j]= Math.min(up , left);
            }
        }
        return dp[m-1][n-1];
    }    
}

