class Solution {
    //Best Approch: 
    //Algo used: Hashing
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Find the longest sequence
        for (int i : set) {
            
            if (!set.contains(i - 1)) {//check if 'i' is a starting number
                // find consecutive numbers
                int cnt = 1;
                int tempIndex = i;
                while (set.contains(tempIndex + 1)) {
                    tempIndex++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
        
    }
    //Better: Sorting , TC: O N * Logn
}