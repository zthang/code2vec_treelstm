void solve() {
    int n = ni(), m = ni();
    DJSet ds = new DJSet(n);
    for (int i = 0; i < m; i++) {
        ds.union(ni() - 1, ni() - 1);
    }
    int ans = 0;
    for (int x = 0; x < n; ) {
        int min = ds.min[x];
        int max = ds.max[x];
        int i;
        for (i = min; i <= max; i++) {
            if (!ds.union(min, i)) {
                ans++;
            }
            max = Math.max(max, ds.max[ds.root(min)]);
        }
        x = i;
    }
    out.println(ans);
}