class Solution {
    public int longestValidParentheses(String s) {
        // Initialize stack to store indices of parentheses
        Stack<Integer> a = new Stack<>();
        // Add sentinel value -1 to handle length calculation from start
        a.add(-1);
        // Variable to track the maximum length of valid substring
        int len = 0;
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // If opening parenthesis, push its index onto the stack
            if (s.charAt(i) == '(') { 
                a.add(i); 
            } 
            // If closing parenthesis
            else {
                if (s.charAt(i) == ')') {
                    // Pop the top index (either matching '(' or previous unmatched point)
                    a.pop();
                    // If stack is empty, push current index as new starting point
                    if (a.isEmpty()) { 
                        a.add(i); 
                    }
                    // Calculate length of current valid substring and update max if greater
                    int max = i - a.peek();
                    if (max > len) { 
                        len = max; 
                    }
                }
            }
        }
        return len;
    }
}