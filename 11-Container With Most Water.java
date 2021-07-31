class Solution {
    public int maxArea(int[] height) {
        int maxRes = 0, lo = 0, hi = height.length - 1;

        while(lo < hi) {
            maxRes = Math.max(maxRes, Math.min(height[lo], height[hi]) * (hi - lo));
            if(height[lo] < height[hi]) {
                lo ++;
            } else {
                hi --;
            }
        }
        return maxRes;
    }
}