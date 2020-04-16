private static int firstPos(Integer[] a, int t) {
    int first = a.length;
    int l = 0, r = a.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (a[mid] >= t) {
            first = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return first;
}