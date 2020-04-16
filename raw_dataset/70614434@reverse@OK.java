// Reverse an array
static void reverse(int[] arr, int l, int r) {
    while (l < r) {
        int tmp = arr[l];
        arr[l++] = arr[r];
        arr[r++] = tmp;
    }
}