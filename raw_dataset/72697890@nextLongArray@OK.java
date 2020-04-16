public long[] nextLongArray(int n, int off) {
    long[] arr = new long[n + off];
    for (int i = 0; i < n; i++) {
        arr[i + off] = nextLong();
    }
    return arr;
}