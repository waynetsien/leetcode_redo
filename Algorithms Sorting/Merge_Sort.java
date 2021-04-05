public class MergeSort {

    public static void main(String[] args) {
        // 待测试的排序数组
        int[] arr = {5,1,13,19,3,9,12,14,17};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tempArr = new int[high - low + 1];
        int left = low, right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] > arr[right]) {
                tempArr[index++] = arr[right++];
            } else {
                tempArr[index++] = arr[left++];
            }
        }

        while (left <= mid) {
            tempArr[index++] = arr[left++];
        }

        while (right <= high) {
            tempArr[index++] = arr[right++];
        }

        System.arraycopy(tempArr, 0, arr, low, high - low + 1);
    }
}