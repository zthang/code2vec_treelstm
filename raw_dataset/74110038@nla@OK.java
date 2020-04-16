long[] nla(int start, int n) throws IOException {
    long[] a = new long[n];
    for (int i = start; i < n; i++) {
        a[i] = nl();
    }
    return a;
}