public static int lowerBound(long[] a, long v) {
    int l = 0, h = a.length - 1, ans = -1;
    while (l < h) {
        int mid = (l + h) / 2;
        if (v <= a[mid]) {
            ans = mid;
            h = mid - 1;
        } else
            l = mid - 1;
    }
    return ans;
}