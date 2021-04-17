class Solution {
    public String reverseStr(String s, int k) {
        char[] words = s.toCharArray();
        int n = words.length, left = 0, right;

        while (left < n) {
            // 可以控制 当前time中的字符个数num < k的情况，直接right取num
            right = Math.min(left + k - 1, n - 1);
            reverseVal(words, left, right);
            left += 2 * k;
        }

        return new String(words);
    }

    public void reverseVal(char[] a, int left, int right) {
        while(left < right) {
            char temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
    }
}