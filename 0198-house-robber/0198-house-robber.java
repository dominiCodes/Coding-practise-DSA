class Solution {
    // Recursion TC: O 2 ^ N , SC: O N
    // Algo Used Pick Not Pick
    // public int rob(int[] nums) {
    //     int ind= nums.length-1;
    //     return f(nums, ind);
    // }

    // public int f(int[] nums, int ind){
    //     if(ind == 0){
    //         return nums[ind];
    //     }
    //     if(ind < 0){
    //         return 0;
    //     }
    //     int pick= nums[ind] + f(nums, ind-2);
    //     int notPick= 0 + f(nums, ind-1);
    //     return Math.max(pick, notPick);
    // }

    // //Memoization - TC: O N , SC: O N + O N
    // public int rob(int[] nums) {
    //     int n= nums.length;
    //     int[] dp= new int[n];
    //     Arrays.fill(dp, -1);
    //     return f(nums, n-1, dp);
    // }

    // public int f(int[] nums, int ind, int[] dp){
    //     if(ind == 0){
    //         return nums[ind];
    //     }
    //     if(ind < 0){
    //         return 0;
    //     }

    //     if(dp[ind] != -1){
    //         return dp[ind];
    //     }
    //     int pick= nums[ind] + f(nums, ind-2, dp);
    //     int notPick= 0 + f(nums, ind-1, dp);
    //     return dp[ind]= Math.max(pick, notPick);
    // }


    //  //Tabulation - TC: O N , SC: O N
    // public int rob(int[] nums) {
    //     int n= nums.length;
    //     int[] dp= new int[n];
    //     dp[0]= nums[0];
    //     for(int i=1; i< n; i++){
    //             int pick= nums[i];
    //             if(i>1){
    //                 pick+= dp[i-2];
    //             } 
    //         int notPick= 0 + dp[i-1];
    //         dp[i]= Math.max(pick, notPick);
    //     }
    //     return dp[n-1];
    // }


    //Tabulation - Spave Optimization - TC: O N , SC: O 1
    public int rob(int[] nums) {
        int n= nums.length;
        int prev1= nums[0];
        int prev2= 0;
        for(int i=1; i< n; i++){
                int pick= nums[i];
                if(i>1){
                    pick+= prev2;
                } 
            int notPick= 0 + prev1;
            int curr = Math.max(pick, notPick);
            prev2= prev1;
            prev1= curr;
        }
        return prev1;
    }
 }

