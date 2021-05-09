class Solution {
    // Time:O(n) Space:O(1)
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int flag = 0;

        for (int num : nums) {
            flag ^= num;
        }

        int diff = flag & (-flag);

        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int i = 0;
        Set<Integer> diff = new HashSet<>();

        for (int num : nums) {
            if (diff.contains(num)) {
                diff.remove(num);
            } else {
                diff.add(num);
            }
        }

        for (int val : diff) {
            res[i++] = val;
        }

        return res;
    }

}