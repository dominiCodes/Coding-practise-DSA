class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if(n == 0) return 0;

        int totalPoisonedSeconds = 0;
        for(int i = 0; i < n - 1; i++){
            if(timeSeries[i] + duration > timeSeries[i + 1]){
                totalPoisonedSeconds += timeSeries[i + 1] - timeSeries[i];
            }
            else{
                totalPoisonedSeconds += duration;
            }
        }
        return totalPoisonedSeconds + duration;
    }
}