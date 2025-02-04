class Solution {
    public int minFlips(String tar) {
       int n=tar.length();
       int count=0;
       int res=0;
       for(int i=0;i<n;i++)
       {
        char ch=tar.charAt(i);
            if(count%2==0 && ch=='1')
            {
                count++;
                res++;
            }
            if(count%2==1 && ch=='0')
            {
                count++;
                res++;
            }
       } 
       return count;
    }
}