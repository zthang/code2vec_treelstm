int[] nextIntArray(int n, int delta) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = nextInt() + delta;
    return a;
}