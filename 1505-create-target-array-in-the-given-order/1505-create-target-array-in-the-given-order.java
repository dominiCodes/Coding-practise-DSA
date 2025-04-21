class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            target.add(index[i],nums[i]); 
        }
        int[] arr = new int[target.size()];
        for (int i = 0; i < target.size(); i++) {
            arr[i] = target.get(i);  
        }
        return arr;
        
    }
}