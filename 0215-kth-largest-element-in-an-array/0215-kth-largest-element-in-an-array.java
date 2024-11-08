// Brute Force: Sorting the arr, TC: O NLogN
// Optimized: Using Heap, TC: O NLogK
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(); // Mind Heap
        for(int i=0; i< n; i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){ // Keeping the size K , so at the top kth largest element will be there
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}