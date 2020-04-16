private static void merge_sort(long[] A, long start, long end) {
    if (start < end) {
        long mid = (start + end) / 2;
        merge_sort(A, start, mid);
        merge_sort(A, mid + 1, end);
        merge(A, start, mid, end);
    }
}