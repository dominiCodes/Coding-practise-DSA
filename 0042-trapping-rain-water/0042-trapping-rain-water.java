class Solution {
    // Algo Used: Two pointers
    // TC: O N , SC: O 1
    public int trap(int[] height) {
        int n= height.length; // initialization
        int left=0; // 1st pointer
        int right= n-1;  // 2nd pointer
        int leftMax= 0; // leftMaxHieght
        int rightMax= 0;  // rightMaxHieght
        int ans=0;

        while(left<= right){ // run loop until left pointer <= right pointer to cover all the elements.
            if(height[left]<= height[right]){ // if left block is less than first check that
                if(height[left] >= leftMax){ // update the max
                    leftMax= height[left];
                }else{      // else if there is space for water in less than(<) leftMax condition,then add it in ans (Not if even there is a black there it will be subracted accordingly,
                //like if height[left]=1 and leftMax =2 then it wil do leftMax - height[left] and add 1 in the ans as per requirment.
                    ans+= leftMax - height[left];
                }
                left++;
            }else{ // do the same when the right block is less
                if(height[right] >= rightMax){
                    rightMax= height[right];
                }else{
                    ans+= rightMax - height[right];
                }
                right--;
            }
        }
        return ans; // in the end ans will contain all the water blocks, return it :)
    }


    //Brute Force:
    //TC: O N ^ 2 , SC: O 1
    // public int trap(int[] arr) {
    //     int n = arr.length;
    //     int waterTrapped = 0;
    //     for (int i = 0; i < n; i++) { // for each element we are traversing the entire array again
    //         int j = i;
    //         int leftMax = 0, rightMax = 0;
    //         while (j >= 0) {
    //             leftMax = Math.max(leftMax, arr[j]);
    //             j--;
    //         }
    //         j = i;
    //         while (j < n) {
    //             rightMax = Math.max(rightMax, arr[j]);
    //             j++;
    //         }
    //         waterTrapped += Math.min(leftMax, rightMax) - arr[i];
    //     }
    //     return waterTrapped;
    // }
}