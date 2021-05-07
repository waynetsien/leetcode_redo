class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // size1为nums1的大小 ，size2为nums2的大小，newSize为nums1扩容后的大小
        int size1 = m - 1, size2 = n - 1, newSize = m + n - 1;
        while (size1 >= 0 && size2 >= 0) {
            nums1[newSize--] = (nums1[size1] > nums2[size2]) ? nums1[size1--] : nums2[size2--];
        }

        while (size2 >= 0) {
            nums1[newSize--] = nums2[size2--];
        }
    }
}