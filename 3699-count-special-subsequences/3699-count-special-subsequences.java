class Solution
{
    // GCD memoization table
    private int[][] gcdMemo;

    public Solution()
    {
        // Step 1: Initialize the GCD memoization table with -1
        gcdMemo = new int[1001][1001];
        for (int[] row : gcdMemo)
        {
            Arrays.fill(row, -1); // Fill with -1 to signify uncomputed values
        }
    }

    // Step 2: Define a memoized GCD function
    private int memoizedGCD(int a, int b)
    {
        if (a == 0)
        {
            return b; // Base case: GCD of (0, b) is b
        }
        if (b == 0)
        {
            return a; // Base case: GCD of (a, 0) is a
        }
        if (gcdMemo[a][b] != -1)
        {
            return gcdMemo[a][b];
        }

        return gcdMemo[a][b] = memoizedGCD(b, a % b); // Compute and store the result
    }

    // Step 3: Normalize a pair (x, y) to its smallest ratio using GCD
    private int[] normalize(int x, int y)
    {
        int gcd = memoizedGCD(x, y); // Compute the GCD of x and y
        return new int[]{x / gcd, y / gcd}; // Return the reduced pair
    }

    public long numberOfSubsequences(int[] nums)
    {
        int n = nums.length; // Step 4: Length of the input array
        if (n == 0)
        {
            return 0; // Handle edge case for an empty array
        }

        int maxVal = Arrays.stream(nums).max().orElse(0);
        Map<String, Integer> pairCount = new HashMap<>();
        long result = 0;
        int q = 0; 

        // Step 5: Outer loop to iterate over all possible values of r
        for (int r = 0; r < n; ++r)
        {
            // Step 6: Move q to r - 1 and count all valid pairs (nums[p], nums[q])
            while (q + 1 < r)
            {
                for (int p = 0; p < q - 1; ++p)
                {
                    int[] key = normalize(nums[p], nums[q]); // Normalize (nums[p], nums[q])
                    String keyString = key[0] + "," + key[1]; // Convert normalized pair to string
                    pairCount.put(keyString, pairCount.getOrDefault(keyString, 0) + 1); // Update frequency
                }
                ++q; // Move q forward
            }

            // Step 7: Count matching pairs for s > r + 1
            for (int s = r + 2; s < n; ++s)
            {
                int[] key = normalize(nums[s], nums[r]); 
                String keyString = key[0] + "," + key[1]; 
                result += pairCount.getOrDefault(keyString, 0);
            }
        }

        return result;
    }
}