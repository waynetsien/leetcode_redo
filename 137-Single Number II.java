class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >>> i & 1) == 1) {
                    oneCount++;
                }
            }

            if (oneCount % 3 == 1) {
                res |= (1 << i);
            }
        }
        return res;
    }
}