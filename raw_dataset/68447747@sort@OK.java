public static void sort(long[] arr, int start, int end) {
    if (start >= end)
        return;
    int mid = (start + end) / 2;
    sort(arr, start, mid);
    sort(arr, mid + 1, end);
    merge(arr, start, mid, end);
}