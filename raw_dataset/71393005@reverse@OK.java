// Reverse an array
static void reverse(long[] arr, int l, int r) {
    while (l < r) {
        long tmp = arr[l];
        arr[l++] = arr[r];
        arr[r--] = tmp;
    }
}