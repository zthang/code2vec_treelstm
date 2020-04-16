static long[] long_arr() throws IOException {
    String[] a = read().split(" ");
    long[] b = new long[a.length];
    for (int i = 0; i < a.length; i++) {
        b[i] = long_v(a[i]);
    }
    return b;
}