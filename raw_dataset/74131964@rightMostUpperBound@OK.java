// return the right most index i such that a[i] <= t
private static int rightMostUpperBound(Integer[] a, int t) {
    int l = 0, r = a.length - 1;
    while (l < r - 1) {
        int mid = l + (r - l) / 2;
        if (a[mid] <= t) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    if (a[r] <= t) {
        return r;
    } else if (a[l] <= t) {
        return l;
    }
    return -1;
}