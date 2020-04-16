private static void rev(int[] a, int i, int j) {
    while (i < j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        ++i;
        --j;
    }
}