// Algo Used: Sliding Window / Two Pointers
// TC: O N , SC: O 1
// In our window we are only keeping k zeroes , if the zeroes exceeds k then we are shrinking the window to at least k zeroes while moving and in the mean time calculating the maxLenth while sliding the windows
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n= nums.length;
        int i=0;
        int j=0;
        int zeroes= 0;
        int max= 0;
        while(j < n){ 
                if(nums[j] == 0){
                    zeroes++;
                }
                if(zeroes > k){ // if exceeds zero then
                    if(nums[i] == 0){   // shifting left index until zeroes is not <= k
                        zeroes--;
                        i++;
                    }else{
                        i++;
                    }
                }   
                if(zeroes <= k){    // will calculate max length only when zeroes will come within k
                    max= Math.max(max, j-i +1);
                }             
                j++;    // keep on increasing right pointer
        }
        return max;
    }
}