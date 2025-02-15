class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list for graph representation
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Priority Queue (Min-Heap) for Dijkstra's Algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Start with the source node
        
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get the node with the smallest time
            int node = curr[0], time = curr[1];

            if (dist.containsKey(node)) continue; // Skip if already visited
            
            dist.put(node, time);
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], nextTime = neighbor[1];
                if (!dist.containsKey(nextNode)) {
                    pq.offer(new int[]{nextNode, time + nextTime});
                }
            }
        }
        
        if (dist.size() != n) return -1; // If not all nodes are reached, return -1
        return Collections.max(dist.values()); // Return the maximum time taken
    }
}