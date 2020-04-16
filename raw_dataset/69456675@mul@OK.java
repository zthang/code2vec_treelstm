long[][] mul(long[][] arr, long[][] brr, int a, int b, int c, int d) {
    long[][] crr = new long[a][d];
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < d; j++) {
            for (int k = 0; k < b; k++) {
                crr[i][j] += (((arr[i][k] % 1000000007) * (brr[k][j] % 1000000007)) % 1000000007);
            }
        }
    }
    return crr;
}