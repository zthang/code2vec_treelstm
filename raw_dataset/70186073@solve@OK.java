static void solve() {
    int n = in.nextInt();
    int k = in.nextInt();
    char[] s = in.next().toCharArray();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
        a[i][0] = a[i][1] = -1;
    }
    for (int i = 0; i < k; i++) {
        int m = in.nextInt();
        for (int j = 0; j < m; j++) {
            int x = in.nextInt() - 1;
            if (a[x][0] == -1) {
                a[x][0] = i;
            } else {
                a[x][1] = i;
            }
        }
    }
    int ans = 0;
    DSU dsu = new DSU(k);
    for (int i = 0; i < n; i++) {
        if (a[i][1] != -1) {
            int v = a[i][0];
            int u = a[i][1];
            if (dsu.find(v) != dsu.find(u)) {
                ans -= dsu.count(v);
                ans -= dsu.count(u);
                if (s[i] == '0') {
                    dsu.unite(v, u, 1);
                } else {
                    dsu.unite(v, u, 2);
                }
                ans += dsu.count(v);
            }
        } else if (a[i][0] != -1) {
            int v = a[i][0];
            if (!dsu.colored[v]) {
                ans -= dsu.count(v);
                if (s[i] == '0') {
                    dsu.color(v, 1, true);
                } else {
                    dsu.color(v, 0, true);
                }
                ans += dsu.count(v);
            }
        }
        out.println(ans);
    }
}