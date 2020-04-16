void solve() {
    int n = ni(), m = ni();
    char[] s = ns(n);
    int[][] f = new int[n][2];
    int[] fp = new int[n];
    for (int i = 0; i < m; i++) {
        for (int q = ni(); q > 0; q--) {
            int x = ni() - 1;
            f[x][fp[x]++] = i;
        }
    }
    DJSet ds = new DJSet(2 * m);
    for (int i = 0; i < m; i++) {
        ds.numt[i + m] = 1;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (fp[i] == 0) {
        } else if (fp[i] == 1) {
            int id = f[i][0];
            if (ds.must[ds.root(id)] || ds.must[ds.root(id + m)]) {
            } else {
                ans -= Math.min(ds.numt[ds.root(id)], ds.numt[ds.root(id + m)]);
                if (s[i] == '0') {
                    ds.must[ds.root(id + m)] = true;
                    ans += ds.numt[ds.root(id + m)];
                } else {
                    ds.must[ds.root(id)] = true;
                    ans += ds.numt[ds.root(id)];
                }
            }
        } else if (fp[i] == 2) {
            int id1 = f[i][0];
            int id2 = f[i][1];
            if (s[i] == '0') {
                if (!ds.equiv(id1, id2 + m)) {
                    ans -= go(id1, m, ds);
                    ans -= go(id2, m, ds);
                    ds.union(id1, id2 + m);
                    ds.union(id1 + m, id2);
                    ans += go(id1, m, ds);
                }
            } else {
                if (!ds.equiv(id1, id2)) {
                    ans -= go(id1, m, ds);
                    ans -= go(id2, m, ds);
                    ds.union(id1, id2);
                    ds.union(id1 + m, id2 + m);
                    ans += go(id1, m, ds);
                }
            }
        }
        out.println(ans);
    }
}