static int rec(int m, int l, int r) {
    if (l >= r)
        return 0;
    long ans = 0;
    int min = Integer.MAX_VALUE;
    for (int i = l; i < r; i++) min = Math.min(min, a[i]);
    ans = min - m;
    int st = l;
    for (int i = l; i < r; i++) {
        if (a[i] <= min) {
            ans += rec(min, st, i);
            st = i + 1;
        }
    }
    ans += rec(min, st, r);
    return (int) Math.min(ans, r - l);
}