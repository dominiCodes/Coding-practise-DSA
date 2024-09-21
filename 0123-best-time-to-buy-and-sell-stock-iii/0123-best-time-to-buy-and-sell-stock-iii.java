class Solution {
    //Recurrsion
    // public int maxProfit(int[] prices) {
    //     int n= prices.length;
    //     return f(prices, 0, 1, 2); // ind, buy, capacity
    // }

    // public int f(int[] prices, int ind, int buy, int capacity){
    //     if(capacity == 0) return 0;  // if 2 transactions occured then also return 0 
    //     if(ind == prices.length) return 0; // base case, if index gets out of bound then if there is any stock buied which is not sold so we have to ignore it so make that as 0

    //     int profit=0;
    //     if(buy == 1){   // buying all possibilites
    //         int take= -prices[ind] + f(prices, ind+1, 0, capacity);
    //         int notTake= 0 + f(prices, ind+1, 1, capacity);
    //         profit= Math.max(take, notTake);
    //     }else{      // selling all possibilites
    //         int sell= prices[ind] + f(prices, ind+1, 1, capacity-1);
    //         int notSell= 0 + f(prices, ind+1, 0, capacity);
    //         profit= Math.max(sell, notSell);
    //     }
    //     return profit;  // in eache level we will be adding max profit
    // }


    // Memization
    // public int maxProfit(int[] prices) {
    //     int n= prices.length;
    //     int[][][] dp= new int[n][2][3];
    //     for (int row1[][] : dp){
    //         for (int row2[] : row1) {
    //          Arrays.fill(row2, -1);
    //         }
    //     }
    //     return f(prices, 0, 1, 2, dp);
    // }    

    // public int f(int[] prices, int ind, int buy, int capacity, int[][][] dp){
    //     if(capacity == 0) return 0;
    //     if(ind == prices.length) return 0; // base case, if index gets out of bound then if there is any stock buied which is not sold so we have to ignore it so make that as 0

    //     if(dp[ind][buy][capacity] != -1){
    //         return dp[ind][buy][capacity];
    //     }

    //     int profit=0;
    //     if(buy == 1){   // buying all possibilites
    //         int take= -prices[ind] + f(prices, ind+1, 0, capacity, dp);
    //         int notTake= 0 + f(prices, ind+1, 1, capacity, dp);
    //         profit= Math.max(take, notTake);
    //     }else{      // selling all possibilites
    //         int sell= prices[ind] + f(prices, ind+1, 1, capacity-1 , dp);
    //         int notSell= 0 + f(prices, ind+1, 0, capacity, dp);
    //         profit= Math.max(sell, notSell);
    //     }
    //     return dp[ind][buy][capacity]= profit;  // in eache level we will be adding max profit
    // }


        //Tabulation
        public int maxProfit(int[] prices){
        int n= prices.length;
        int [][][] dp= new int[n+1][2][3];
        
        for(int i=0; i<n; i++){// base case for i<n put 0's, only for understanding  no need to write bcz array is by default zero
            for(int buy=0; buy<=1; buy++){
                dp[i][buy][0]= 0;
            }
        }
         for(int buy=0; buy<=1; buy++){ //base case for maxTransaction<0 put 0's only for understanding  no need to write bcz array is by default zero
            for(int maxTransaction=0; maxTransaction<=2; maxTransaction++){
                dp[n][buy][maxTransaction]= 0;
            }
        }
            
        for(int i= n-1; i>=0; i--){
            int profit=0;
            for(int buy=0; buy<=1; buy++){
                for(int maxTransaction=1; maxTransaction<=2; maxTransaction++){
                   if(buy==1){  // buying 
            int take= -prices[i] + dp[i+1][0][maxTransaction]; // buying ith on day and here it -prices[i] becxause we are buying it 
            int notTake= 0 + dp[i+1][1][maxTransaction]; // not buying ith  onday
            profit= Math.max(take, notTake);
            dp[i][buy][maxTransaction]= profit;
                       
                }else if(buy==0){  // selling
                       
            int take= prices[i] + dp[i+1][1][maxTransaction-1];// selling on ith day and here it +prices[i] because we are selling it 
            int notTake= 0 + dp[i+1][0][maxTransaction]; // not selling on ith day
            profit= Math.max(take, notTake);   
            dp[i][buy][maxTransaction]= profit;
        }
     }
  }  
 }
          return dp[0][1][2];
}
 }

