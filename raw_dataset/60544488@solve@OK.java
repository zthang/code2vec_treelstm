void solve() {
    int n = ni(), m = ni();
    DJSet ds = new DJSet(n);
    for (int i = 0; i < m; i++) {
        int a = ni() - 1, b = ni() - 1;
        ds.union(a, b);
    }
    int ct = ds.count();
    int sol = 0;
    for (int i = 0; i < n; i++) {
        if (-ds.upper[i] == 1) {
            sol++;
        }
    }
    int two = ct - sol;
    int one = n - sol - 2 * two;
    out.println(m - two - one);
}