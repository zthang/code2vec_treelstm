public static int[] swap(int[] arr, int low, int high) {
    int temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;
    return arr;
}