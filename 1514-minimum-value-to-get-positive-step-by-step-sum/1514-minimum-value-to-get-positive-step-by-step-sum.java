class Solution {
    public int minStartValue(int[] nums) {
        int start=0;
        int min =0;
        for(int i : nums){
            start+=i;
            min = Math.min(start,min);
        }
        return min<0?Math.abs(min)+1 : min+1;
    }
}