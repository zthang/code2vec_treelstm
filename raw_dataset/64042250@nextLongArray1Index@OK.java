public long[] nextLongArray1Index(int n) {
    long[] res = new long[n + 1];
    for (int i = 0; i < n; i++) {
        res[i + 1] = nextLong();
    }
    return res;
}