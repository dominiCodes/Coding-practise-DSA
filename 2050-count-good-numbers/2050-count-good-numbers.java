class Solution {
    public long MOD = 1_000_000_007;
    
    public int countGoodNumbers(long n) {
        long odd = n / 2;  // Count of odd positions
        long even = (n + 1) / 2;  // Count of even positions
        
        // Multiply the results of pow(5, even) and pow(4, odd), then take the result modulo MOD
        return (int)((pow(5, even) * pow(4, odd)) % MOD);
    }
    
    // Modular exponentiation function
    public long pow(long x, long n) {
        if (n == 0) 
            return 1;
        
        long temp = pow(x, n / 2);

        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        } else {
            return (x * temp * temp) % MOD;
        }
    }
}