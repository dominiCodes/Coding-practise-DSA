class Solution {


 // Algo SLiding Window, Hashing, My approach , look this
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0; // Handle the case when the string is empty
        }

        int i = 0; // Left pointer of the sliding window
        int j = 0; // Right pointer of the sliding window
        int max = 0; // Store the maximum length of substring without repeating characters
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }




//  Best: 
//Algo Used: Sliding Window , Hashing

//     public int lengthOfLongestSubstring(String s) {
//         int n= s.length();
//         int left=0; // start of substring
//         int right=0; // end of substring
//         int len=0;
//         Map<Character, Integer> map= new HashMap<>();
//         while(right < n){
//             if(map.containsKey(s.charAt(right))){ //if char is already presenet then move left pointer by taking the Max of (the last occurence of char +1 , already present left pointer)
//                 left= Math.max(map.get(s.charAt(right))+1, left);

//             }

//             map.put(s.charAt(right), right); // keep on putting al ele in map
//             len= Math.max(len, right - left +1); // keep on taking the max Len 
//             right++;
//         }
//         return len; 
//     }
// }


   
}







