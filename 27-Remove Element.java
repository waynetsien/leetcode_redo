/**
 * <p>
 *     public int removeElement(int[] nums, int val) {
 *         if (nums.length == 0) {
 *             return 0;
 *         }
 *         List<Integer> list = new ArrayList<>(nums.length);
 *         for (int i = 0; i < nums.length; i++) {
 *             list.add(nums[i]);
 *         }
 *
 *         Iterator<Integer> itr = list.iterator();
 *         while(itr.hasNext()) {
 *             if (itr.next().equals(val)) {
 *                 itr.remove();
 *             }
 *         }
 *         return list.size();
 *     }
 * </p>
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // while循环，若等于val时，整体往左移，并n--；
        for (int i = 0; i < n; ) {
            if (nums[i] == val) {
                for (int j = i + 1; j < n; j++) {
                    nums[j-1] = nums[j];
                }
                n--;
            } else {
                // 不等于val则就i+1，往右移动找等于val的位置
                i++;
            }
        }
        return n;
    }
}
