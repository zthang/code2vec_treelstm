static long[] nla(int n) throws IOException {
    long[] data = new long[n];
    for (int i = 0; i < n; i++) {
        data[i] = nl();
    }
    return data;
}