class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Last index of valid elements in nums1
        int j = n - 1; // Last index of valid elements in nums2
        int k = m + n - 1; // Last index in nums1
        
        // Merge from the end of nums1 and nums2
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]; // Place nums1[i] at the end and move pointers
            } else {
                nums1[k--] = nums2[j--]; // Place nums2[j] at the end and move pointers
            }
        }
        
        // Copy remaining elements from nums2 if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
