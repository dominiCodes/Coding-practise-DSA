//Algo Used: Sorting , tow pointer
//TC: O NlogN, SC: O 1 (excluding the output string)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n= strs.length;
        Arrays.sort(strs); // this will sort the string , so now we just have to compare first and last string (think based on sorted seq then we just have to compare first last only)
        String first= strs[0];
        String last= strs[n-1];
        StringBuilder ans= new StringBuilder();
        for(int i=0; i< Math.min(first.length(),last.length()); i++){
           if(first.charAt(i) != last.charAt(i)){ // if chars doesnt ,match then return ans
            return  ans.toString();
           }
            ans.append(first.charAt(i));    // else keep appending it ans
            
        }
        return ans.toString();
    }
}