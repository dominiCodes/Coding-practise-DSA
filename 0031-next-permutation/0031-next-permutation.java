class Solution {
 
    // Algo used: Breakpoint technique 
    //Basic Logic, checking the array from last to get the exact next permuataion
    // TC: 3N , SC: O 1
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int breakingPointIndex= -1;

        // we are always traversing array from back bcz we want to get the greatest ele from last.
        for(int i= n-2; i>=0; i--){  // checking if the array is fully sorted
            if(nums[i] < nums[i+1]){
                breakingPointIndex= i; // finding the breaking point
                break; // break so avoid change in breakinhPoint
            }
        }

        if(breakingPointIndex == -1){  // if fully sorted than reverse entire array and return
            reverse(nums, 0, n-1);
            return;
        }

        for(int i= n-1; i> breakingPointIndex; i--){ 
            if(nums[i] > nums[breakingPointIndex]){  // finding the exact next greatest
                int temp= nums[i]; // swap
                nums[i]= nums[breakingPointIndex];
                nums[breakingPointIndex]= temp;
                break; // break to avoid finding more greater values because we want the eaxact next greater
            }
        }

        reverse(nums, breakingPointIndex + 1, n-1); // revere from breakPoint+1 till n
    }


    public void reverse(int[] nums, int start, int end){ // reverisnig
            while(start < end){
                int temp= nums[start];
                nums[start]= nums[end];
                nums[end]= temp;
                start++; end--;
            }
    }
}