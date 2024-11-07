class Solution {
    // Algo Used: Kadanes's Alogrithm
    // TC: O N , SC: O 1
    public int maxSubArray(int[] nums) { 
        
        int max=nums[0];
        int sum=0;

        for(int i=0; i< nums.length; i++){
            sum+= nums[i];
             max= Math.max(max, sum); // check if we got a new max
             if(sum<0){ // if are having our sum in negtive, mark it as 0 to avoid reducing maximmm sum
                sum=0;
            }
        }
        return max;
    }
}