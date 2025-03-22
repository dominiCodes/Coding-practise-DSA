class Solution {
    public int[] diStringMatch(String s) {
        int inc = 0;
        int dec = s.length();
        int[] result = new int[s.length()+1];

        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'I') {
                result[i] = inc;
                inc++;
            } else {
                result[i] = dec;
                dec--;
            }
        }
        result[s.length()] = inc;
        return result;
    }
}