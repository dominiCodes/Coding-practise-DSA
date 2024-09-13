class Solution {
    // Algo Used: Binary Search
    // TC: O LonN , SC: O 1
    public int[] searchRange(int[] nums, int target) {
        int ans[]= {-1,-1};

        ans[0]= search(nums, target, true); //checking in first half
        ans[1]= search(nums, target, false); //checking in second half
        
        return ans;
    }

    public int search(int[] nums, int target, boolean isStartIndex){ // binary search

        int start=0;
        int end= nums.length - 1;
        int ans= -1;

        while(start <= end){
            int mid = start + (end - start ) / 2;
            if(target > nums[mid]){
                start= mid+1;
            }else if(target < nums[mid]){
                end= mid-1;
            }else{
                ans= mid;
                if(isStartIndex){ //search in first hald for potential ans
                    end= mid-1;
                }else{  // search in second hald for potential ans
                    start= mid+1;
                }
            }
        }
        return ans;
    }
}