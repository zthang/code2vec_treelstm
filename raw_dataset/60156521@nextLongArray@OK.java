public long[] nextLongArray(int n, long add) {
    long[] result = new long[n];
    for (int i = 0; i < n; i++) {
        result[i] = nextLong() + add;
    }
    return result;
}