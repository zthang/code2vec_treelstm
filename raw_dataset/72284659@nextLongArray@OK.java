Long[] nextLongArray(int n) {
    Long[] a = new Long[n];
    for (int i = 0; i < n; i++) {
        a[i] = nextLong();
    }
    return a;
}