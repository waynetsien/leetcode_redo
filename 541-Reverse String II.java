class Solution {
    public String reverseStr(String s, int k) {
        char[] charStr = s.toCharArray();
        int left = 0, right;

        while (left < charStr.length) {
            right = Math.min(left + k - 1, charStr.length - 1);
            reverseVal(charStr, left, right);
            left += 2*k;
        }

        return new String(charStr);
    }

    public void reverseVal(char[] a, int left, int right) {
        while (left < right) {
            char temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
    }
}