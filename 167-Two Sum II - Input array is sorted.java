/**
 * 由于是有序数组，所以可以前后往中间推移，相加判断
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int start = 0, end = numbers.length - 1;

        while(start < end) {
            int res = numbers[start] + numbers[end];
            if(res == target) {
                arr[0] = start+1;
                arr[1] = end+1;
                break;
            } else if (res < target) {
                start++;
            } else {
                end--;
            }
        }
        return arr;
    }
}