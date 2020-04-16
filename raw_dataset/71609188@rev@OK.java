public static void rev(int[] a, int l, int r) {
    if (l >= r)
        return;
    int n = r - l + 1;
    for (int i = 0; i < n / 2; i++) {
        int t = a[l + i];
        a[l + i] = a[l + n - 1 - i];
        a[l + n - 1 - i] = t;
    }
}