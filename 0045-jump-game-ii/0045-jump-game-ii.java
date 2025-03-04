// Brute force: Using Recursion TC -> N^N
// Optimized: Using DP -> TC: N*N
//Most Optimized: Using Greedy algo with ranges -> TC: O N , (without range we have to take an extra arr to sotre the curr min reach, but with taking range we can eluminate that space)

class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int l=0;
        int r=0;
        int jump= 0;
        while(r < n-1){ // until r has not reach the n-1 index, while reaching n-1 or beyound stop the loop.
        int maxReach= 0;
        for(int i= l; i<= r; i++){  // calculating the max Reach
            maxReach= Math.max(maxReach,i+ nums[i]);
        }
            l= r+1; // moving into begining of new range starting from r+1
            r= maxReach;    // r goint to the end of the newRange which was the maxReach calculated
            jump= jump+1;   // increasing jumps by 1
        }
        return jump;
    }
}