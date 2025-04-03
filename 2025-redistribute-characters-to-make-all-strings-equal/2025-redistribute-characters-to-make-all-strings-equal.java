class Solution {
    public boolean makeEqual(String[] words) {
        int[] ans=new int[26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                ans[words[i].charAt(j)-'a']++;
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]%words.length!=0){
                return false;
            }
        }
        return true;
    }
}