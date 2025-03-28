class Solution{
public int numEquivDominoPairs(int[][] dominoes) {

        int[][] counts = new int[10][10];
        int res = 0;

    for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            
            res += counts[a][b];
            if(a != b)
                res += counts[b][a];
            
            counts[b][a]++;            
        }

        return res;
    }
}