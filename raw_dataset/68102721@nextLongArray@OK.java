long[] nextLongArray(int n) throws IOException {
    long[] a = new long[n];
    for (int i = 0; i < n; i++) a[i] = in.nextLong();
    return a;
}