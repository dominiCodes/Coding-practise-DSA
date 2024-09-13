class Solution {  
    // Algo Used: Binary Search (Finding Peak/Pivot Element)
    // TC: O Log N , SC: O 1
    public int search(int[] nums, int target) {
        int start=0;
        int end= nums.length-1;
        int pivot= findPivot(nums);  // pivot is basically rhe largest element

        if(pivot == -1){  // if no pivot that mean no rotation so do normal BS
            return bs(nums, target, start, end);
        }

        if(nums[pivot] == target){ // if pivot is target, return pivot
            return pivot;
        }


        if(target >= nums[start]){ // searching in first half i.e prior to pivot
            return bs(nums, target, start, pivot-1);
        }else{
            return bs(nums, target, pivot+1 , end); // searching in second half i.e after pivot
        }
        
    }

     public int findPivot(int nums[]){  // finding pivot

        int start=0;
        int end= nums.length-1;

        while(start<= end){
            int mid= start + (end - start) / 2;

            if(mid < end && nums[mid] > nums[mid+1]){ // got pivot
                return mid;
            }
//            case2
            if(mid > start && nums[mid] <nums[mid-1]){  // got pivot
                return mid -1;
            }
            if(nums[mid] <= nums[start]){  // pivot lies in first half
                end = mid - 1;
            }else{  // pivot lies in second half
                start = mid + 1;
            }
        }
        return -1;
    }


    public int bs(int[] nums, int target, int start, int end){  // BS

        while(start <= end){
            int mid= start + (end - start) / 2;
            if(nums[mid] > target){
                end= mid -1;
            }else if(nums[mid] < target){
                start= mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}