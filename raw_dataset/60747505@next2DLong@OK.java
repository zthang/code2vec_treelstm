long[][] next2DLong(int n, int m) {
    long[][] arr = new long[n][];
    for (int i = 0; i < n; i++) {
        arr[i] = nextLongArray(m);
    }
    return arr;
}