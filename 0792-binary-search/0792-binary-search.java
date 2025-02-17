class Solution {

    // Linear approach
    public int search(int[] nums, int target) {
        
        int start=0;
        int end= nums.length - 1;
    
        while(start <= end){
            int mid= start + (end - start)/2; // atlernate of (mid + end) /2
            if(target< nums[mid]){
                end= mid - 1;
            }else if(target > nums[mid]){
                start= mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


// // Using Recurrsion
// // note: if we have some return type then add return in the reccurence relation
// public int search(int[] nums, int target) {

//         return f(nums, target, 0, nums.length-1);
// }

//     public int f(int[] nums, int target, int start, int end){

//         if(start > end){ // base case
//             return -1;
//         }

//         // func body 
//         int mid= start + (end - start) / 2;

//         if(nums[mid] == target){   // found ans
//             return mid;
//         }

//                 // reccurence relation
//         if(nums[mid] < target){
//             return f(nums, target, mid+1, end);  // search in right half
//         }else{
//             return f(nums, target, start, mid-1);  // seatch in left half
//         }
//     }
}
