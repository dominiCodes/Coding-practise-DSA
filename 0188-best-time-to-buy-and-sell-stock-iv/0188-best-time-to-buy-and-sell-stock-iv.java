class Solution {
 
        //Recurrsion
        // See Stock 2 code
        
        
        //Memoization
        // Se stock 2 code


        //Tabulation
        public int maxProfit(int k, int[] prices){
        int n= prices.length;
        int [][][] dp= new int[n+1][2][k+1];
        
        for(int i=0; i<n; i++){// base case for i<n put 0's, only for understanding  no need to write bcz array is by default zero
            for(int buy=0; buy<=1; buy++){
                dp[i][buy][0]= 0;
            }
        }
         for(int buy=0; buy<=1; buy++){ //base case for maxTransaction<0 put 0's only for understanding  no need to write bcz array is by default zero
            for(int maxTransaction=0; maxTransaction<=k; maxTransaction++){
                dp[n][buy][maxTransaction]= 0;
            }
        }
            
        for(int i= n-1; i>=0; i--){
            int profit=0;
            for(int buy=0; buy<=1; buy++){
                for(int maxTransaction=1; maxTransaction<=k; maxTransaction++){
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
          return dp[0][1][k];
}
 }

