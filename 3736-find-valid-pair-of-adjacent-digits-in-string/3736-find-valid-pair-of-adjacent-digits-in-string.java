import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String findValidPair(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int x = Character.getNumericValue(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            int a = Character.getNumericValue(currentChar);
            int b = Character.getNumericValue(nextChar);

            if (a != b && map.get(currentChar) == a && map.get(nextChar) == b) {
                return "" + currentChar + nextChar;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "1122334455";
        String result = solution.findValidPair(input);
        System.out.println("Valid pair: " + result); 
        
        input = "1234567890";
        result = solution.findValidPair(input);
        System.out.println("Valid pair: " + result); 
        
        input = "1221";
        result = solution.findValidPair(input);
        System.out.println("Valid pair: " + result); 
    }
}