static int lower_bound(long[] a, int n, long k) {
    int s = 0;
    int e = n;
    int m;
    while (e - s > 0) {
        m = (s + e) / 2;
        if (a[m] < k)
            s = m + 1;
        else
            e = m;
    }
    return e;
}