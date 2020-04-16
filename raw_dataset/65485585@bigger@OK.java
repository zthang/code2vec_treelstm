public static int bigger(long[] a, int lo, int hi, long key) {
    while (lo < hi) {
        int mid = (lo + hi) >>> 1;
        if (a[mid] > key) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
}