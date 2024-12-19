class Solution {
    //Algo used: Cyclic sort
    // TC: O N , SC: O 1
    public int findDuplicate(int[] nums) {

        int n= nums.length;
        int i=0;
        while(i < n){
            if(nums[i] != i+1){    // check if the inx is not on the correct posi already so that we can properly compare the duplicate ele and not compare it with it self.

            int correctPosi= nums[i]-1;
            if(nums[i] != nums[correctPosi]){
                int temp= nums[i];     //swap
                nums[i]= nums[correctPosi];
                nums[correctPosi]= temp;
            }else{
                return nums[i];  // nums[i] == nums[correctPosi], means found duplicate
            }
        } else{
            i++;
        }
    }
        return -1;
   }




    //Brute forece: Sorting arr and solving
    // More optimized: Using Hash Table
    //Most Optimized: Using tortoise(slow/fast pointer) method, REFER NOTES
    // public int findDuplicate(int[] nums) {
        
    //     int slow= nums[0];
    //     int fast= nums[0];

    //     do{
    //         slow= nums[slow]; // moving by one distance 
    //         fast= nums[nums[fast]];  // moving by two distance
    //     }while(slow != fast);

    //     fast= nums[0];   // resetting fast
    //     while(slow != fast){ // moving again so they will meet at duplicate
    //         slow= nums[slow];
    //         fast= nums[fast];
    //     }
    //     return slow; // returing slow/fast (both will be at same location at end)
    // }
}