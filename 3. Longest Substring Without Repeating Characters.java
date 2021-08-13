class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int maxRes = 0;
        for (int left = 0, i = 0; i < s.length(); i++) {
            if (!maps.containsKey(s.charAt(i))) {
                maxRes = Math.max(maxRes, i - left + 1);
            } else {
                if (maps.get(s.charAt(i)) >= left) {
                    left = maps.get(s.charAt(i)) + 1;
                } else {
                    maxRes = Math.max(maxRes, i - left + 1);
                }
            }
            maps.put(s.charAt(i), i);
        }

        return maxRes;
    }
}