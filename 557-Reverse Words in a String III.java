/**
 * 1、split string by space
 * 2、reverse each string
 * 3、append them
 */
class Solution {
    public String reverseWords(String s) {
        // split string by space
        String[] subStr = s.split(" ");

        // reverse each string
        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = new StringBuilder(subStr[i]).reverse().toString();
        }

        // append them
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < subStr.length; i++) {
            result.append(subStr[i] + " ");
        }

        return result.toString().trim();
    }
}