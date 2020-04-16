public static int upperBound(long[] a, long v) {
    int l = 0, h = a.length - 1, ans = -1;
    while (l < h) {
        int mid = (l + h) / 2;
        if (a[mid] <= v) {
            ans = mid;
            l = mid + 1;
        } else
            h = mid - 1;
    }
    return ans;
}