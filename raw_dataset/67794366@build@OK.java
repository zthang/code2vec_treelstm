static void build(long[] sum, int[] arr, int n) {
    for (int i = 0; i < (1 << n); i++) {
        long total = 0;
        for (int j = 0; j < n; j++) {
            if ((i & (1 << j)) > 0)
                total += arr[j];
        }
        sum[i] = total;
    }
}