class Solution {
    //Recurrsion
    // public int maxProfit(int[] prices) {
    //     int n= prices.length;
    //     return f(prices, 0, 1);
    // }

    // public int f(int[] prices, int ind, int buy){
    //     if(ind == prices.length) return 0; // base case, if index gets out of bound then if there is any stock buied which is not sold so we have to ignore it so make that as 0

    //     int profit=0;
    //     if(buy == 1){   // buying all possibilites
    //         int take= -prices[ind] + f(prices, ind+1, 0);
    //         int notTake= 0 + f(prices, ind+1, 1);
    //         profit= Math.max(take, notTake);
    //     }else{      // selling all possibilites
    //         int sell= prices[ind] + f(prices, ind+1, 1);
    //         int notSell= 0 + f(prices, ind+1, 0);
    //         profit= Math.max(sell, notSell);
    //     }
    //     return profit;  // in eache level we will be adding max profit
    // }


    // Memization
    // public int maxProfit(int[] prices) {
    //     int n= prices.length;
    //     int[][] dp= new int[n][2];
    //     for(int[] rows : dp){
    //         Arrays.fill(rows, -1);
    //     }
    //     return f(prices, 0, 1, dp);
    // }

    // public int f(int[] prices, int ind, int buy, int[][] dp){
    //     if(ind == prices.length) return 0; // base case, if index gets out of bound then if there is any stock buied which is not sold so we have to ignore it so make that as 0

    //     if(dp[ind][buy] != -1){
    //         return dp[ind][buy];
    //     }

    //     int profit=0;
    //     if(buy == 1){   // buying all possibilites
    //         int take= -prices[ind] + f(prices, ind+1, 0, dp);
    //         int notTake= 0 + f(prices, ind+1, 1, dp);
    //         profit= Math.max(take, notTake);
    //     }else{      // selling all possibilites
            // int sell= prices[ind] + f(prices, ind+1, 1, dp);
            // int notSell= 0 + f(prices, ind+1, 0, dp);
            // profit= Math.max(sell, notSell);
    //     }
    //     return dp[ind][buy]= profit;  // in eache level we will be adding max profit
    // }


        //Tabulation
        // public int maxProfit(int[] prices) {
        // int n= prices.length;
        // int[][] dp= new int[n+1][2];

        // dp[n][0]= 0;  // base case
        // dp[n][1]= 0;

        // for(int ind=n-1; ind>=0; ind--){
        //     for(int buy=0; buy<=1; buy++){
        //         int profit=0;
        //             if(buy == 1){   // buying all possibilites
        //             int take= -prices[ind] + dp[ind+1][0];
        //             int notTake= 0 + dp[ind+1][1];
        //             profit= Math.max(take, notTake);
        //          }else{
        //             int sell= prices[ind] + dp[ind+1][1];
        //             int notSell= 0 + dp[ind+1][0];
        //             profit= Math.max(sell, notSell);
        //          } 
        //          dp[ind][buy]= profit;  
        //         }
        //     }     
        //     return dp[0][1]; // returning [0][1] and not [0][0] bcz we will get the max prfoit alfter selling stock, and after selling it will be present in 1 and not 0
        // }         



        // Tabulation - Space Optimization
        public int maxProfit(int[] prices) {
        int n= prices.length;
        int[] next= new int[2];
        int[] curr= new int[2];

        next[0]= 0;  // base case
        next[1]= 0;

        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                int profit=0;
                    if(buy == 1){   // buying all possibilites
                    int take= -prices[ind] + next[0];
                    int notTake= 0 + next[1];
                    profit= Math.max(take, notTake);
                 }else{
                    int sell= prices[ind] + next[1];
                    int notSell= 0 + next[0];
                    profit= Math.max(sell, notSell);
                 } 
                 curr[buy]= profit;  
                }
                next= curr;
            }     
            return next[1]; // returning [0][1] and not [0][0] bcz we will get the max prfoit alfter selling stock, and after selling it will be present in 1 and not 0
        }   
}

 

