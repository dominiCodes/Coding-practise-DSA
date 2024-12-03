class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case
        if (numRows == 0) return triangle;

        // Add the first row [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build the triangle row by row
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // First element of each row is always 1
            currentRow.add(1);

            // Calculate the intermediate values
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element of each row is always 1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}
