class Solution {
    //Recurrsion
    // public boolean canPartition(int[] nums) {
    //     int target= 0;
    //     int n= nums.length;
    //     for(int i : nums){
    //         target+= i;
    //     }
    //     if(target%2 != 0){
    //         return false;
    //     }

    //     return f(nums, n-1, target/2);
    // }

    // public boolean f(int[] nums, int ind, int target){
    //     if(target == 0) return true;
    //     if(ind == 0 ) return (nums[ind] == target);

    //     boolean notTake= f(nums, ind-1, target);
    //     boolean take= false;
    //     if(target >= nums[ind]){
    //         take= f(nums, ind-1, target - nums[ind]);
    //     }
    //     if(take || notTake) return true;
    //     else{
    //         return false;
    //     }
    // }


    //Memoization
//     public boolean canPartition(int[] nums) {
//         int target= 0;
//         int n= nums.length;

//         for(int i : nums){ // calculate target
//             target+= i;
//         }
//         if(target%2 != 0){  // if target is odd then we cant make partitions, return false
//             return false;
//         }

//         int dp[][]= new int[n][target+1];
    
//         for(int row[]: dp){ // initiazlize dp
//             Arrays.fill(row,-1);
//         }

//         return f(nums, n-1, target/2, dp); // f call with calculated target
//     }


//     // In memoization we cant store the 2d dp in boolean form because we have to check wheter
// //     the posi is -1 or not so while storing and returning in dp treat 0 and 1 as true and
// //     false respectively and convert them accordingly
//     public boolean f(int[] nums, int ind, int target, int[][] dp){
//         if(target == 0) return true;
//         if(ind == 0) return (nums[ind] == target);
        
//         if(dp[ind][target] != -1){ 
//           if(dp[ind][target]==0)return false;  // 0 is false
//             else 
//                 return true;    // 1 is true
//         }      
       
//         boolean take= false;
        
//         if(target >= nums[ind]){
//             take= f(nums, ind-1, target-nums[ind], dp);
//         }
//         boolean notTake= f(nums, ind-1, target, dp);
              
//         if(take || notTake){// storing the values in dp
//            dp[ind][target]=1; 
//         }else{
//            dp[ind][target]=0;
//         }
        
//         if(dp[ind][target]==0)return false;  // return the values
//             else 
//                 return true;
//     }



    // Tabulation
    public boolean canPartition(int[] arr) {  
    int n= arr.length;
    int k=0;
    for(int i : arr){ // calculate target
            k+= i;
        }
        if(k%2 != 0){  // if target is odd then we cant make partitions, return false
            return false;
        }

        k= k/2;
        
    boolean dp[][]= new boolean[n][k+1];
    
    for(int i=0; i<n; i++){// storing true in all cells of k=0
        dp[i][0] = true;
    }
    
    if(arr[0]<=k)// sotring true on the row 0th and col arr[0]th 
        dp[0][arr[0]] = true;
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=k; target++){
           
            boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];
            
            boolean notTaken = dp[ind-1][target];
                       
            if(notTaken||taken){
                dp[ind][target]=true;
            }else{
                dp[ind][target]=false;
            }
        }
    }
    return dp[n-1][k];  
    }    
}