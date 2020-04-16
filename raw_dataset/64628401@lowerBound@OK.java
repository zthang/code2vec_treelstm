private static int lowerBound(long[] arr, long key) {
    int lo = 0;
    int hi = arr.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (key <= arr[mid]) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return arr[lo] < key ? lo + 1 : lo;
}