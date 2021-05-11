class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }

        res[index++] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[index++] = deque.peekFirst();
        }

        return res;
    }
}