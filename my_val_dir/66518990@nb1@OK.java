private long[] nb1(int n) {
    long[] a = new long[n + 1];
    for (int i = 1; i < n + 1; i++) {
        a[i] = nl();
    }
    return a;
}