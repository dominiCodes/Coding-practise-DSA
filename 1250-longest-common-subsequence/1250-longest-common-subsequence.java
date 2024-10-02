class Solution {
    // Recurrsive
    // public int longestCommonSubsequence(String text1, String text2) {
        
    //     return f(text1, text2, text1.length()-1, text2.length()-1);
    // }

    // public int f(String s1, String s2, int ind1, int ind2){
    //     if(ind1<0 || ind2<0) return 0;

    //     if(s1.charAt(ind1) == s2.charAt(ind2)){ // take
    //         return  1 + f(s1, s2, ind1-1, ind2-1);
    //     }

    //     return Math.max(f(s1, s2, ind1-1, ind2), f(s1, s2, ind1, ind2-1));  // not taking each from both string at a time
    // }


    // Memoization
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int[][] dp= new int[text1.length()][text2.length()];
    //     for(int[] rows : dp){
    //         Arrays.fill(rows, -1);
    //     }
    //     return f(text1, text2, text1.length()-1, text2.length()-1, dp);
    // }

    // public int f(String s1, String s2, int ind1, int ind2, int[][] dp){
    //     if(ind1<0 || ind2<0) return 0;
        
    //     if(dp[ind1][ind2] != -1){
    //         return dp[ind1][ind2];
    //     }
    //     if(s1.charAt(ind1) == s2.charAt(ind2)){
    //         return  dp[ind1][ind2]= 1 + f(s1, s2, ind1-1, ind2-1, dp);
    //     }

    //     return dp[ind1][ind2]= Math.max(f(s1, s2, ind1-1, ind2, dp), f(s1, s2, ind1, ind2-1, dp));
    // }


    // Tabulation
    // Here we are using the method of shifting indexes to left by 1 to handle -1 posi base case
    // like for ind -1 we are taking it as 0, for 1 -> 0 , for 2 -> 1 and so on...
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();
        int[][] dp= new int[n+1][m+1];

        // no need to write below base cases bcz it will be by default initialize with 0
        for(int i=0; i< dp.length; i++){
            dp[i][0]= 0;
        }
        for(int i=0; i< dp[0].length; i++){
            dp[0][i]= 0;
        }

        for(int i=1; i<= n; i++){
            for(int j=1; j<= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1];
                }else{
                    dp[i][j]= 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}