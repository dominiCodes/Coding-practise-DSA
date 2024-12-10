class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        Set<Character> map=new HashSet<>();
        for(char i:jewels.toCharArray())
        {
            map.add(i);
        }
        for(char i:stones.toCharArray())
        {
            if(map.contains(i))
            {
                count++;
            }
        }
        return count;
    }
}