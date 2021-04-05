public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        Random random = new Random();
        int pivotIndex = random.nextInt(hi - lo + 1) + lo;
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, hi);
        int savedPosition = hi;
        hi--;

        while (lo <= hi) {
            if (arr[lo] > pivotValue) {
                swap(arr, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }

        swap(arr, lo, savedPosition);
        return lo;
    }

    private static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}