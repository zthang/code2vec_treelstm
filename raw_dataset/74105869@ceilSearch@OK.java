public static int ceilSearch(int l, int r, long val, long[] ar) {
    int mid;
    while (l + 1 != r && l < r) {
        mid = (l + r) / 2;
        if (ar[mid] < val)
            l = mid;
        else
            r = mid;
    }
    if (ar[l] >= val)
        return l;
    else if (ar[r] >= val)
        return r;
    else
        return -1;
}