class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        int[] res = new int[n];  
        int index = 0;  

        for (int i = 0; i < n; i++) {
            String op = operations[i];

            if (op.equals("+")) {
                res[index] = res[index - 1] + res[index - 2];
                index++;
            } else if (op.equals("D")) {
                res[index] = 2 * res[index - 1];
                index++;
            } else if (op.equals("C")) {
                index--;  
                res[index] = 0;
            } else {
                res[index] = Integer.parseInt(op);  
                index++;
            }
        }

        int sum = 0;
        for (int j = 0; j < index; j++) {
            sum += res[j];
        }

        return sum;
    }
}