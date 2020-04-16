long[] readLongArray(int n) {
    long[] a = new long[n];
    for (int idx = 0; idx < n; idx++) {
        a[idx] = nextLong();
    }
    return a;
}