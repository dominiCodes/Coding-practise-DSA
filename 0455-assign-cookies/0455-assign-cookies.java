//Algo used: Greedy
// TC: O N logn + M logM + O N
// SC: O 1

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i= 0;   // g pointer
        int j=0;    // s pointer
        while(i < g.length && j < s.length){ // do until any arr goes out of bound
            if(g[i] <= s[j]){   
                i++;
            }
            j++;
        }
        return i;
    }
}