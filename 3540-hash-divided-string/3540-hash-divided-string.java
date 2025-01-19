class Solution {
    public String stringHash(final String s, final int k) {
        final StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i += k) {
            final int size = i + k;
            int sum = 0;

            for(int j = i; j < size; ++j)
                sum += s.charAt(j) - 'a';

            sb.append((char) (sum % 26 + 'a'));
        }

        return sb.toString();
    }
}