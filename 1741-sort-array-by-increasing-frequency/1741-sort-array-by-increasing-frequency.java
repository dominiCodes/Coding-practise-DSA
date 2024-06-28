import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a max-heap to sort elements by frequency and then by value,
        // This comparator ensures that entries with higher frequencies are processed 
        // first (b.getValue() - a.getValue()), and if frequencies are tied, entries
        //  with higher keys (values in the original array) are processed first (b.getKey() - a.getKey()).
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        // Step 3: Build the result array
        int[] result = new int[nums.length];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            int value = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result[index++] = value;
            }
        }

        return result;
    }
}
