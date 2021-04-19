class Solution {
    public int missingNumber(int[] nums) {
        int xorResult = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xorResult = xorResult ^ i ^ nums[i];
        }
        return xorResult;
    }
}