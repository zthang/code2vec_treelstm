public static int lower_bound(long[] a, int fromIndex, int toIndex, long val) {
    if (val > a[toIndex])
        return toIndex + 1;
    if (val <= a[fromIndex])
        return fromIndex;
    int lb = fromIndex - 1, ub = toIndex;
    while (ub - lb > 1) {
        int mid = (ub - lb) / 2 + lb;
        if (a[mid] >= val) {
            ub = mid;
        } else {
            lb = mid;
        }
    }
    return ub;
}