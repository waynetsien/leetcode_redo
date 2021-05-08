class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int left = i + 1, right = nums.length - 1;
                int newTarget = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] > newTarget) {
                        right--;
                    } else if (nums[left] + nums[right] < newTarget) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        right--;
                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }
}