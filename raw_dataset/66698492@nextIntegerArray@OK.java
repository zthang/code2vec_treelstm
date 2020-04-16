public Integer[] nextIntegerArray(int n) throws IOException {
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++) a[i] = nextInt();
    return a;
}