import java.util.*;
// Step 1: loop and conut for fresh oranges and  add rotten ones in queue
//Step 2:If there are no fresh oranges then return 0 // edge case
//Ste 3: Do BFS starting from the rotten oranges added in queue in step 1
// Step4: Include a boolean isChanged variable which will change to true if any orange is rotted ,
//  if rotted then after the inner loop do ans++ and even do the freshOranges--
// Before coming out of loop check if there the freshOrange is 0 i.e no fresh orange left, if so then return the ans bcz all our fresh would be converted into rotten over here
class Pair {
    int first;
    int sec;

    public Pair(int first, int sec) {
        this.first = first;
        this.sec = sec;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1, 0, +1, 0}; // storing the indexes to traverse in four directions
        int delcol[] = {0, +1, 0, -1}; // storing the indexes to traverse in four directions
        int ans = 0;
        int countFresh = 0;

        Queue<Pair> q = new LinkedList<>();

        // Count initial fresh oranges and add rotten oranges to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    countFresh++;
                else if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }

        // If there are no fresh oranges initially, return 0
        if (countFresh == 0)
            return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean changed = false;

            // Process all currently rotten oranges
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                int row = pair.first;
                int col = pair.sec;

                // Check neighbors
                for (int k = 0; k < 4; k++) {
                    int nrow = row + delrow[k];
                    int ncol = col + delcol[k];

                    // If neighbor is within bounds and is a fresh orange
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2; // Make it rotten
                        q.add(new Pair(nrow, ncol)); // Add to queue for next iteration
                        countFresh--; // Decrement count of fresh oranges
                        changed = true; // Mark that at least one orange became rotten
                    }
                }
            }

            if (changed) // If any orange became rotten in this iteration
                ans++; // Increment time

            // If there are no more fresh oranges left, return time
            if (countFresh == 0)
                return ans;
        }

        // If there are still fresh oranges left after BFS, it's not possible to rot all oranges
        return -1;
    }
}
