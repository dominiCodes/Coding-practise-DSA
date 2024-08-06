class Solution {
    public int majorityElement(int[] nums) {

   // Algo Used: Conuting method, refer notes
   // Counting method keeps on counting the no. of elements by adding and subracting and at the end in the ans the ele with most occurence(counts) will remain
//    TC: O N , SC: O 1
   int ans=0;
   int count =0;
   for(int i=0; i< nums.length; i++){ // at the end after adding and subracting the most no. of ele will remain
       if(count == 0){
           count=1;
           ans= nums[i];
       }else if(ans == nums[i]){ 
           count++;
       }else{
           count--;
       }
   }
    return ans;

   

   
        //TC: O N lOgN  SC: N
    //    int n = nums.length; 
    //    Map<Integer, Integer> map = new HashMap<>();
        
    //     for (int i = 0; i < n; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }
        
    //     n = n / 2;
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (entry.getValue() > n) {
    //             return entry.getKey();
    //         }
    //     }
    //     return 0;
    }
}














