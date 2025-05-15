class Solution {
    public int maxStudents(char[][] seats) {
        return dpMemoization(seats);
    }
    
    private int dpMemoization(char[][] seats) {
        int[][] cache = new int[seats.length][1 << seats[0].length];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        
        return dpMemoization(seats, 0, 0, cache);
    }
    
    private int dpMemoization(char[][] seats, int i, int previousRow, int[][] cache) {
        if (i == seats.length) {
            return 0;
        }
        
        if (cache[i][previousRow] != -1) {
            return cache[i][previousRow];
        }
        
        int rowLength = seats[0].length;
        int brokenSeats = 0;
        for (int j = 0; j < rowLength; j++) {
            if (isBroken(seats[i][j])) {
                brokenSeats |= 1 << j;
            }
        }
        
        // for row of length M we can have 2^M possible options to seat the students
        int rowCombinations = 1 << rowLength;
        int result = 0;
        // going through all possible combinations for current row seats 
        // excluding forbidden (a chair is broken or some adjastent chairs in this or previous row are taken, so student can cheat)
        for (int currentRow = 0; currentRow < rowCombinations; currentRow++) {
            // trying to take some chairs that are broken, skipping this
            if ((brokenSeats & currentRow) != 0) {
                continue;
            }
            
            // left seat in this row is taken, cannot take this
            if ((currentRow & (currentRow << 1)) != 0) {
                continue;
            }
            
            // right seat in this row is taken, cannot take this
            if ((currentRow & (currentRow >>> 1)) != 0) {
                continue;
            }
            
            // upLeft seats in previous row is taken, cannot take this
            if ((currentRow & (previousRow << 1)) != 0) {
                continue;
            }
            
            // upRight seats in previous row is taken, cannot take this
            if ((currentRow & (previousRow >>> 1)) != 0) {
                continue;
            }
            
            int studentsInCurrentRow = countBits(currentRow);
            result = Math.max(
                result,
                studentsInCurrentRow + dpMemoization(seats, i + 1, currentRow, cache)
            );
        }        
        
        cache[i][previousRow] = result;
        return result;
    }
    
    private boolean isBroken(char c) {
        return c == '#';
    }
    
    private int countBits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}