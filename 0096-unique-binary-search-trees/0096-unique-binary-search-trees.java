class Solution {

    public int helper(int node, int lower, int upper, int[][][] dp){
        if(upper - lower == 2)
            return 1;
        if(dp[node][lower][upper] != -1)return dp[node][lower][upper];
        //left child
        
        int left  = 0;
        for(int i=lower+1; i<node; i++){
            left += helper(i, lower, node, dp);
        }

        //right child 
        int right = 0;
        for(int i=node+1; i<upper; i++){
            right+= helper(i, node,  upper, dp);
        }
        left = left==0?1:left;
        right = right==0?1:right;
        return  dp[node][lower][upper] = left*right;
    }

    public int numTrees(int n) {
        int count = 0;
        int[][][] dp = new int[n+1][n][n+2];
        for(int x[][] : dp)
            for(int y[] : x)
                Arrays.fill(y, -1);
        for(int i = 1; i<=n; i++){
            count+= helper(i, 0, n+1, dp);
        }
        return count;
    }
}