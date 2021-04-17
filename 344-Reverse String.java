class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length == 1) {
            return;
        }

        int n = s.length, left = 0, right = n-1;
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}