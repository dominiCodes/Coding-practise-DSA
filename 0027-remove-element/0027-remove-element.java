class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length; 
        int lastInd = nums.length - 1; // Index of the last element in the array
        int countOfVal = 0; // To count occurrences of 'val' in the array
        
        // Loop through the array from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // If the current element is equal to 'val'
            if (nums[i] == val) {
                countOfVal++; // Increment the count of 'val'
                swap(nums, i, lastInd); // Swap the current element with the element at 'lastInd'
                lastInd--; // Decrement 'lastInd' to exclude the swapped element
            }
        }
        
        // The new length of the array is the original length minus the count of 'val'
        return n - countOfVal;
    }

    // Helper function to swap elements at indices 'i' and 'j' in the array 'nums'
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
