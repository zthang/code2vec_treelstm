private long[] readLongArray(int n) {
    long[] res = new long[n];
    for (int i = 0; i < n; i++) {
        res[i] = sc.nextLong();
    }
    return res;
}