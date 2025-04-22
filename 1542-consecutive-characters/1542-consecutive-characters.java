class Solution {
    public int maxPower(String s) {
        int[] freq=new int[s.length()];
        if(s.length()==1)return 1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int n=(int)c-97;
            freq[i]=n;
        }
        int max=0;
        int cnt=1;
        for(int i=1;i<freq.length;i++){
            if(freq[i-1]==freq[i])cnt++;
            else cnt=1;
            max=Math.max(cnt,max);
        }
        /*max=Math.max(cnt,max);
        if(max<cnt){
            max=cnt;
        }
        //*/
        return max;
    }
}