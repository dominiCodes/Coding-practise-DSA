class Solution {
    public int smallestNumber(int n) {
        int b = (int) (Math.log(n) / Math.log(2)) + 1;  // Calculate the number of bits
        return (1 << b) - 1;                           // Return 2^b - 1
    }
}