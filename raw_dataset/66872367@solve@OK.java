void solve() {
    int t = ni();
    for (int i = 0; i < t; ++i) {
        int n = ni();
        int m = ni();
        int a = ni() - 1;
        int b = ni() - 1;
        g = new ArrayList[n];
        for (int j = 0; j < n; ++j) {
            g[j] = new ArrayList<>();
        }
        for (int j = 0; j < m; ++j) {
            int u = ni() - 1;
            int v = ni() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        vis = new boolean[n];
        long c = 1;
        long[] suan = new long[2];
        for (int j = 0; j < n; ++j) {
            if (j == a || j == b || vis[j])
                continue;
            ct = 0;
            hasV = false;
            hasU = false;
            dfs(j, -1, a, b);
            if (hasV && hasU) {
            } else if (hasV) {
                suan[0] += ct;
            } else if (hasU) {
                suan[1] += ct;
            }
        }
        println(suan[0] * suan[1]);
    }
}