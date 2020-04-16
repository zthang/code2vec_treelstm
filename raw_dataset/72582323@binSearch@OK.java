int binSearch(int[] a, int x) {
    int l = -1, mid, r = a.length;
    while (l + 1 < r) {
        mid = (l + r) / 2;
        if (a[mid] >= x)
            r = mid;
        else
            l = mid;
    }
    return r;
}