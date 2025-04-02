class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
		String str = "balon"; // balloon
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (str.contains(Character.toString(ch))) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int count = map.getOrDefault(str.charAt(i), 0);
			if (ch == 'l' || ch == 'o') {
				count /= 2;
			}
			min = Math.min(count, min);
		}
		return min;
    }
}