public static void sort(int[] a, int l, int r) {
    int m;
    if (l < r) {
        m = (l + r) / 2;
        sort(a, l, m);
        sort(a, m + 1, r);
        merge(a, l, m, r);
    }
}