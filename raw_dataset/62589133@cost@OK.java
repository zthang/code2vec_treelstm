public static long cost(int n, int[] t, long[] A, long[] B, long[] C) {
    long c = 0;
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0) {
            c = c + A[t[i]];
        } else if (i % 3 == 1) {
            c = c + B[t[i]];
        } else {
            c = c + C[t[i]];
        }
    }
    return c;
}