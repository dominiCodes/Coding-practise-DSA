import java.util.Hashtable;
class Solution {
    public int firstUniqChar(String s) {
        Hashtable<Character , Integer> hashtable = new Hashtable<>();
        for (char c : s.toCharArray())
        {
            hashtable.put(c ,  hashtable.getOrDefault(c , 0) +1);
        }

        if (!hashtable.containsValue(1)) return -1;

        for (int i = 0; i < s.length(); i++) {
            if (hashtable.get(s.charAt(i)) == 1) return i;
        }        
        
        return -1;
    }
}