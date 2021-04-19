class Solution {
    // solution1：use sum t - sum s = get added char
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;
        for (char c : s.toCharArray()) {
            sumS += c;
        }
        for (char c : t.toCharArray()) {
            sumT += c;
        }
        return (char) (sumT - sumS);
    }

    // solution2：use xor
    public char findTheDifference(String s, String t) {
        char result = t.charAt(t.length()-1);

        for (int i = 0; i < t.length()-1; i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        return result;
    }
}