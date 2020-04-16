public static void sort(int[] arr, int l, int u) {
    int m;
    if (l < u) {
        m = (l + u) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, u);
        merge(arr, l, m, u);
    }
}