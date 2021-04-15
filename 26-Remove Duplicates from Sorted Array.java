class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        while(j < n) {
            // while循环，j++ 目的是找两者不等的数，用于下面的swap，注意j < n防止数组越界
            while(j < n && nums[i] == nums[j]) {
                j++;
            }
            if(j < n) {
                i++;
                swap(nums, i, j);
                j++;
            }
        }
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}