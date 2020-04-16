public long[] gla(int n, int start, int end) throws IOException {
    validate(n, start, end);
    long[] a = new long[n];
    for (int i = start; i < end; i++) {
        a[i] = nl();
    }
    return a;
}