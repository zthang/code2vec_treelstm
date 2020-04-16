int[] unique(int[] a) {
    int p = 1;
    for (int i = 1; i < a.length; ++i) {
        if (a[i] != a[i - 1]) {
            a[p++] = a[i];
        }
    }
    return Arrays.copyOf(a, p);
}