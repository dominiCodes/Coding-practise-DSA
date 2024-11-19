//Approches
//1. O n^2 - iterating using 2 for loops
//2. O nlogn - Sorting array -> keeping 2 pointers start and end -> increase and decrease acc to the sum
//3. O n + (O n space)Using HashMap - Store the nums[i] and check if nums[i]- target is present in our map

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Algo Used: Solved using Hashmap
        // TC: O N  ,  SC: O N
        HashMap<Integer, Integer> map= new HashMap<>();
        int arr[]= new int[2];
        int curr=0;
        for(int i=0; i< nums.length; i++){
            curr= target - nums[i]; 
            if(map.containsKey(curr)){  
                arr[0]= map.get(curr);
                arr[1]= i;
                return arr;
            }
            map.put(nums[i], i);  // storing ele as KEY and indx as VALUE
        }
        return arr;   
    }
}