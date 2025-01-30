class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] arr = new int[51];
        int ans = 0;
        for (int i=0; i < nums.length; i++){
            arr[nums[i]]++;
            if (arr[nums[i]] == 2) {
                ans ^= nums[i];
            }
        }
        return ans;
    }
}