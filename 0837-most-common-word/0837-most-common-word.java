class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Step 1: Handling Banned Words
        HashSet<String> ban = new HashSet<>();
        for(String str : banned) {
            ban.add(str);
        }

        // Step 2: Word Frequency Count
        Map<String, Integer> map = new HashMap<>();
        // Process the paragraph
        for(String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
            // Check if the word is not in the banned set
            if(!ban.contains(word)) {
                // Update the frequency in the map
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Step 3: Remove Empty String Entry
        map.remove("");

        // Step 4: Finding Most Common Word
        String result = "";
        for(String key : map.keySet()) {
            // Update result if the current word has a higher frequency
            if(result.equals("") || map.get(key) > map.get(result)) {
                result = key;
            }
        }

        // Return the most common word
        return result;
    }
}