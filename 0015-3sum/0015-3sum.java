class Solution {
    
    public List<List<Integer>> threeSum(int[] arr) {
        //Best: Using 3 indexes, Keeping i=0 fixed and moving j=i+1 and k=n-1
        //ALgo Used: Sorting and 2 pointers approach.
       List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n= arr.length;
        for (int i = 0; i < n; i++) {
            //remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else { // found the ans
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }


    // Brute Force: Three pointer / 3 for loops basic approach
}