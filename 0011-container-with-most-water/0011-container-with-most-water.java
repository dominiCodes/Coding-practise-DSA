// Algo Used: Two Pointers
class Solution {
    public int maxArea(int[] height) {
        int start = 0; // Initialize the start pointer to the beginning of the array
        int end = height.length - 1; // Initialize the end pointer to the end of the array

        int maxWater = 0; // Variable to store the maximum water area found
        while (start < end) { // Continue while the start pointer is less than the end pointer
            int level = Math.min(height[start], height[end]); // Find the smaller height between the two pointers
            int range = end - start; // Calculate the distance between the two pointers
            int currWater = level * range; // Calculate the water area formed by the current pointers
            maxWater = Math.max(maxWater, currWater); // Update the maximum water area if the current area is larger

            // Move the pointer pointing to the shorter height inward to try to find a taller container
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxWater; // Return the maximum water area found
    }
}
