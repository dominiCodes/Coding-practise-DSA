class Solution {
    public int triplet(int n){
           int target = n*n;
    
        HashSet<Integer> ans = new HashSet<>();
        int count=0;

        for(int i=n-1;i>=1;i--){
            int current = i*i;
            int required = target-current;
         
            if(ans.contains(required)){
                count++;
                count++;
            }
        
            ans.add(current);

        }
        return count;

    }
    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            count+=triplet(i);
        }

     return count;
        
    }
}