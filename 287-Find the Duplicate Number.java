class Solution {
    // cycle 快慢指针 推荐
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public int findDuplicate(int[] nums) {
        int i, result = 0;
        Arrays.sort(nums);
        for (i = 0; i < nums.length; i++) {
            result = nums[i] ^ nums[i+1];
            if (result == 0) {
                break;
            }
        }
        return nums[i];
    }
}