// return the left most index i such that a[i] >= t
private static int leftMostLowerBound(Integer[] a, int t) {
    int l = 0, r = a.length - 1;
    while (l < r - 1) {
        int mid = l + (r - l) / 2;
        if (a[mid] >= t) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    if (a[l] >= t) {
        return l;
    } else if (a[r] >= t) {
        return r;
    }
    return -1;
}