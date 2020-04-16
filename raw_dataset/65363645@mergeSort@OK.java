static void mergeSort(int[] arr, int[] arr2, int l, int r) {
    if (l == r)
        return;
    int m = l + (r - l) / 2;
    mergeSort(arr, arr2, l, m);
    mergeSort(arr, arr2, m + 1, r);
    merge(arr, arr2, l, m, r);
}