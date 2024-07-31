class Solution {

    //The pattern of taking some element and removing some element is know as subset pattern.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> tempAns= new ArrayList<>();
        return f(nums, 0, ans, tempAns);
    }

    public List<List<Integer>> f(int nums[], int ind, List<List<Integer>> ans, List<Integer> tempAns){

        if(ind == nums.length){ // base case, after we traverse all the elements
                ans.add(new ArrayList<>(tempAns));  
                return ans;
        }
        tempAns.add(nums[ind]); // fetching the 0th element of curr list
        f(nums, ind+1, ans, tempAns); // taking first ele
        tempAns.remove(tempAns.size()-1); // removing the 0th element of curr list which was added
        f(nums, ind+1, ans, tempAns); // not taking first ele
        return ans; //backtracking after left and right tree returns thier value from base case.
    }    
}