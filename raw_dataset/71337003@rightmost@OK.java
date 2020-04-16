private static int rightmost(int[] a, int d) {
    // max i s.t. a[i]<=d
    int l = 0, r = a.length - 1;
    if (a[0] > d)
        return -1;
    if (a[r] <= d)
        return r;
    while (r - l > 1) {
        int m = (l + r) / 2;
        if (a[m] > d)
            r = m - 1;
        else
            l = m;
    }
    if (a[r] <= d)
        return r;
    return l;
}