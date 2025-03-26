class Solution {
    public int findJudge(int n, int[][] trust) {
       int[]nodes = new int[n+1];

       for(int[] t : trust){
        nodes[t[0]]-=1;
        nodes[t[1]]+=1;
       } 

       for(int i=1;i<=n;i++){
        if(nodes[i]==n-1){
            return i;
        }

       }
       return -1;
    }
}