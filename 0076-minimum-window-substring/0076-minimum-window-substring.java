// Algo Used: Slinding Window , 2 pounters, Hashing
// TC: O N , SC : O N
class Solution {
    public String minWindow(String s, String t) {
         int i= 0;
        int j= 0;
        int n= s.length();
        int m= t.length();
        int minLen= Integer.MAX_VALUE;;
        HashMap<Character , Integer> map = new HashMap<>();
        int count= 0;   // for counting if we have got all the chars from t in our substring
        int startInd= -1;

        for(int ind = 0 ; ind< m; ind++){   // add all the chars from t in our map
             map.put(t.charAt(ind) , map.getOrDefault(t.charAt(ind) ,0)+1);
        }
        while(j < n){
             if(map.getOrDefault(s.charAt(j) ,0)>0){    // if curr sbubstring has one of the char from t then increase count by 1 (Note: Imp : In our curr substring only the char which are equal from the t will be > 0 , other then t will be in negative value)
                count++;
            }
            map.put(s.charAt(j) , map.getOrDefault(s.charAt(j),0)-1); // adding in map (which ever value we put , we will reduce it freq)
            
            while(count == m){  // jab tak count == k hai chalega, jaisi  count < k  hoga toh break hojayga
                if(j - i + 1 < minLen){
                    minLen= j - i + 1;
                    startInd= i;
                }

                map.put(s.charAt(i) , map.get(s.charAt(i))+1); // found one of the ans so now shrinking left pointer, so now increase the freq
                if(map.get(s.charAt(i))>0){  // updating count
                    count--;
                }
                i++;
            }
            j++;
        }
        if(startInd == -1){
            return "";
        }
        return s.substring(startInd, startInd+minLen);
    }
}