class Solution {
    public int maxProfit(int[] arr) {
        // TC: O N , SC O 1
// from ith element(which is selling) we are checking the min ele from 0th 0 i-1 which will give us the current best profit(cost) then we can compare it to our profit using Math.max

        int min= arr[0];
        int maxProfit=0;
        
        for(int i=0; i < arr.length; i++){
            int cost= arr[i] - min;  // calculate cost 
            maxProfit= Math.max(maxProfit, cost);  // update maxProfit (selling price)
            min= Math.min(min, arr[i]);  // update min element(buy price)
        }
        return maxProfit; // return maxProfit which is our ans
    }
}








