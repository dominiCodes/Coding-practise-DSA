// TC: O N, SC: O 1
class Solution {
      public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; //the modulo operation ensures that k is within the range of 0 to n-1
        reverseNum(nums,0,n-1); // reverse entire array
        reverseNum(nums,0,k-1); // reverse 0 to k
        reverseNum(nums,k,n-1); // reverse k to n
    }
    public void reverseNum(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}