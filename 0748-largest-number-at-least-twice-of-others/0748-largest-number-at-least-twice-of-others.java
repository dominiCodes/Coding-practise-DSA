class Solution {
    public int dominantIndex(int[] nums) {
        int idx=0;
       for(int i=0;i<nums.length;i++){
         if(nums[i]>nums[idx]){
            idx=i;
         }
       }
       for(int i=0;i<nums.length;i++){
        if( i!=idx &&(nums[i]*2)>nums[idx]){
            return -1;
        }
       }

       return idx;
    }
}