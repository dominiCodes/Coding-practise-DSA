class Solution {
    public double trimMean(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int remEle = n/20;
        double count = 0;
        double sum = 0;
        for ( int i = remEle;  i < n-remEle; i++) {
            sum += nums[i];
            count++;
        }
        return sum/count;
    }
}