// Algo Used: Dutch National Flag Algo
// TC: O N , SC: O 1
class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high= nums.length-1;
        
        while(mid <= high){  // keep on moving our 3 pointers accordingly
            if(nums[mid] == 0){ // placeing 0's in correct posi.
                //swap
                swap(nums, mid, low);
                low++; mid++;
            }else if(nums[mid] == 1){ // placeing 1's in correct posi.
                mid++;
            }else{  // if nums[mid] == 2 ,   // placeing 2's in correct posi.
                //swap
                swap(nums, mid, high); 
                high--;
            }
        }
    }
    
    public void swap(int nums[], int x, int y){ // swapping algo
        int temp= nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}