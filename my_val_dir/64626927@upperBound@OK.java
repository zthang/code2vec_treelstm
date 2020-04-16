private static int upperBound(long[] arr, long key) {
    int lo = 0;
    int hi = arr.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (key >= arr[mid]) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return arr[lo] <= key ? lo + 1 : lo;
}