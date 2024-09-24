class Solution {

    // Algo: Cyclic Sort
    // TC: O N , SC: O 1
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;
        int i=0;
        while(i < n){ // Cyclic Sort with ignoring ele which are negative and > n 
            int correctPosi= nums[i]-1;
         
                if(nums[i] >0 && nums[i]<= n && nums[i] != nums[correctPosi]){
                    int temp= nums[i];     //swap
                    nums[i]= nums[correctPosi];
                    nums[correctPosi]= temp;
            }else{
                i++;
        }
        }

        for(int ind=0; ind< n; ind++){ // the first ele with wrong ind, the inx+1 will be our ans
            if(nums[ind] != ind + 1){
                return ind + 1;
            }
        } 
            return n+1;  
    }
}