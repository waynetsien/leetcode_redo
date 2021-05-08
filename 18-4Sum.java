class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j-1]) {
                        int left = j + 1, right = nums.length - 1;
                        int newTarget = target - nums[i] - nums[j];
                        while (left < right) {
                            if (nums[left] + nums[right] > newTarget) {
                                right--;
                            } else if (nums[left] + nums[right] < newTarget) {
                                left++;
                            } else {
                                res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
            }
        }
        return res;
    }
}