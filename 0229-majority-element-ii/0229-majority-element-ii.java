class Solution {

//counting method same as n/2 problem
//here there will be total 3 unique ele in the arr and from that at most 2 can be the ans
//same approach applied with some slight modifications
// here we are taking two counters and ans1, ans2


    public List<Integer> majorityElement(int[] nums) {
         int cnt1=0, cnt2=0;
         int ele1=Integer.MIN_VALUE, ele2=Integer.MIN_VALUE;
         List<Integer> ans= new ArrayList<>();
         for(int i=0; i< nums.length; i++){
             if(cnt1 == 0 && nums[i] != ele2){ // checking the extra second condition bcz we dont want to pick the same ele2/ans2 in ele2/ans1
                 cnt1=1;
                 ele1= nums[i];
             }else if(cnt2 == 0 && nums[i] != ele1){// checking the extra second condition bcz we dont want to pick the same ele1/ans1 in ele2/ans2
                 cnt2=1;
                 ele2= nums[i];
             }else if(ele1 == nums[i]){
                 cnt1++;
             }else if(ele2== nums[i]){
                 cnt2++;
             }else{
                 cnt1--; cnt2--;
             }
         }
// now till here we have taken the two most appearing elemets
//So, now reset counters and do a for loop again to check if ele1 and ele2 is appearing
// more than 3 times or not, if apperaing add in list else dont.
         cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) cnt1++;
            if (nums[i] == ele2) cnt2++;
        }

        int mini = (int)(nums.length / 3) + 1;
        if (cnt1 >= mini) ans.add(ele1);
        if (cnt2 >= mini) ans.add(ele2);
         return ans;
    }



// Same as n/2 problem, just do n/3 and store it in list and return

    //  public List<Integer> majorityElement(int[] nums) {
    //         int n = nums.length; 
    //    Map<Integer, Integer> map = new HashMap<>();
    //    List<Integer> ans= new ArrayList<>(); 
    //     for (int i = 0; i < n; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }
        
    //     n = n / 3;
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (entry.getValue() > n) {
    //              ans.add(entry.getKey());
    //         }
    //     }
    //     return ans;
    // }
    
}