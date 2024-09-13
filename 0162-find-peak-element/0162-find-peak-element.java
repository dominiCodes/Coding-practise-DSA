class Solution {
    public int findPeakElement(int[] arr) {
        int start=0;
        int end= arr.length-1;

        while(start < end){ // the loop will break when both the index will be on the same posi unlike the traditional BS algo

            int mid= start + (end-start) / 2;

            if(arr[mid] < arr[mid+1]){ // case 1: it means arr is in asc order, and we know next ele(mid+1) is greater so move start= mid+1
                start= mid+1;
            }else{ // case 2: it means arr is in desc order, and for desc we dont know that arr[mid]> arr[mid-1] so we cant directly move end to mid-1, there can pe a possibilty that mid is the peak so we are moving end= mid
                end= mid; 
            }
        }
        return start; // or return end, at the end both will be pointing to the peak index
    }
    
}