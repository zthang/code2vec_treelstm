public long[] readLongArray(int n) {
    long[] x = new long[n];
    for (int i = 0; i < n; i++) {
        x[i] = nextLong();
    }
    return x;
}