class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> merged = new ArrayList<>();
        
        // Add the first interval to the merged list
        merged.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = merged.get(merged.size() - 1);
            int[] curr = intervals[i];
            
            // If the current interval overlaps with the last merged one, merge them
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);  // Update the end of the previous interval
            } else {
                // Otherwise, add the current interval to the merged list
                merged.add(curr);
            }
        }
        
        // Convert the list to an array and return
        return merged.toArray(new int[merged.size()][]);
    }
}



    // This is also most optimized code from the prev leetcode acc.
    //  List<int[]> list= new ArrayList<>();
    //     Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        
    //     int start= intervals[0][0];
    //     int end= intervals[0][1];
    //     int n= intervals.length;
    //      for(int i=0; i<n; i++){
    //         if(intervals[i][0] <= end){
    //             end= Math.max(end, intervals[i][1]);
    //         }else{
    //             list.add(new int[]{start, end});
    //             start= intervals[i][0];
    //             end= intervals[i][1];
    //         }
    //     }
    //     list.add(new int[] {start, end});
    //     return list.toArray(new int[0][]);
    // }



        // Brute Force

    // public int[][] merge(int[][] arr) {
        
    //     Arrays.sort(arr, new Comparator<int[]>() {      // comparing arrys based on 0th index
    //         public int compare(int[] a, int[] b) {
    //             return a[0] - b[0];
    //         }
    //     });

    //     List<List<Integer>> ans= new ArrayList<>();

    //     for(int i=0; i< arr.length; i++){ // select an interval:
    //         int start = arr[i][0];
    //         int end = arr[i][1];

    //         //Skip all the merged intervals:
    //         if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {  
    //             continue;
    //         } // like [8,10] 10(end) is smaller than (9,11) in our book eg. so we skipped it, as it will come in the merging intervals 
        
    //         for(int j= i+1; j< arr.length; j++){

    //             if(arr[j][0] <= end){
    //                 end= Math.max(end, arr[j][1]); // we have to take the end value which is max from both the arrays-comparision
    //             }else{
    //                 break;
    //             }
    //         }
    //         ans.add(Arrays.asList(start, end));
    //     }

    //     // Convert List<List<Integer>> to int[][]
    //     int[][] result = new int[ans.size()][2];
    //     for (int i = 0; i < ans.size(); i++) {
    //         result[i][0] = ans.get(i).get(0);
    //         result[i][1] = ans.get(i).get(1);
    //     }

    //     return result; 
    // }
