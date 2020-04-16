private static int getAbsDiff(int[] a, int k) {
    int mx = 0;
    int i, p, c;
    p = (a[0] == -1 ? k : a[0]);
    for (i = 1; i < a.length; i++) {
        c = (a[i] == -1 ? k : a[i]);
        mx = Math.max(mx, Math.abs(c - p));
        p = c;
    }
    return mx;
}