class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0, maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            int oddLen = extendByCenter(s, i, i);
            int evenLen = extendByCenter(s, i-1, i);

            if (oddLen > maxLen) {
                left = i - oddLen / 2;
                right = i + oddLen / 2;
                maxLen = oddLen;
            }

            if (evenLen > maxLen) {
                left = i - evenLen / 2;
                right = i + (evenLen / 2 - 1);
                maxLen = evenLen;
            }
        }

        return s.substring(left, right + 1);
    }

    private int extendByCenter(String str, int left, int right) {
        int maxRes = 1;
        while (left >= 0 && right < str.length()
                && str.charAt(left) == str.charAt(right)) {
            maxRes = right - left + 1;
            left--;
            right++;
        }
        return maxRes;
    }
}