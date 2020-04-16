void sort1(int[] arr, int l, int r) {
    if (l < r) {
        int m = (l + r) / 2;
        sort1(arr, l, m);
        sort1(arr, m + 1, r);
        merge1(arr, l, m, r);
    }
}