public long[] nextLongArrayDec(int n) {
    long[] res = new long[n];
    for (int i = 0; i < n; i++) {
        res[i] = nextLong() - 1;
    }
    return res;
}