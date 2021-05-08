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
        if (nums.length == 0) {
            return 0;
        }
        int curLength = nums.length;
        for (int i = 0; i < curLength; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < curLength; j++) {
                    nums[j-1] = nums[j];
                }
                i--;
                curLength--;
            }
        }
        return curLength;
    }
}
