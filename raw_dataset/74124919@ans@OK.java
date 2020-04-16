static int ans(int[] arr, int n) {
    int max = arr[0] | arr[1];
    for (int i = 1; i < n - 1; i++) {
        max = Math.max(max, arr[i] | arr[i + 1]);
    }
    return max;
}