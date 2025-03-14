class Solution 
{
    public int[][] sortMatrix(int[][] grid) 
    {
        int n = grid.length;
        Map<Integer, List<Integer>> d = new HashMap<>();

        // Step 1: Store elements of each diagonal
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                int key = i - j;
                d.putIfAbsent(key, new ArrayList<>());
                d.get(key).add(grid[i][j]);
            }
        }

        // Step 2: Sort diagonals based on the quadrant
        for (int key : d.keySet()) 
        {
            List<Integer> values = d.get(key);
            if (key >= 0) 
            {
                values.sort(Collections.reverseOrder()); // Bottom-left diagonals (Descending)
            }
            else 
            {
                Collections.sort(values); // Top-right diagonals (Ascending)
            }
        }

        // Step 3: Place sorted values back into the matrix
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                grid[i][j] = d.get(i - j).remove(0);
            }
        }

        return grid;
    }
}