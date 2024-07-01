class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char charI = sb.charAt(i);
            char charJ = sb.charAt(j);

            if (!isVowel(charI)) {
                i++;
            } else if (!isVowel(charJ)) {
                j--;
            } else {
                // Swap vowels
                sb.setCharAt(i, charJ);
                sb.setCharAt(j, charI);
                i++;
                j--;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
