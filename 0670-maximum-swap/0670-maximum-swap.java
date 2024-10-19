public class Solution {
    public int maximumSwap(int num) {
        // Convert the number into a character array to manipulate individual digits
        char[] digits = Integer.toString(num).toCharArray();
        
        // Create an array to store the last position of each digit
        int[] last = new int[10];
        
        // Record the last occurrence of each digit (0-9)
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }
        
        // Traverse the digits, trying to find a larger digit to swap
        for (int i = 0; i < digits.length; i++) {
            // Check if a larger digit exists later in the array
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Perform the swap
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    // Return the result as an integer after the swap
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap was performed, return the original number
        return num;
    }
}
