int solve(int n, int m, boolean[] s, List<Integer>[] g) {
    int[] dist0 = bfs(n, n - n, g);
    int[] distn = bfs(n, n - 1, g);
    int cur = distn[0];
    for (int u = 0; u < n; u++) {
        if (s[u]) {
            for (int v : g[u]) {
                if (s[v]) {
                    return cur;
                }
            }
        }
    }
    List<Integer>[] d0 = lists(n);
    List<Integer>[] dn = lists(n);
    for (int u = 0; u < n; u++) {
        if (s[u]) {
            d0[dist0[u]].add(u);
            dn[distn[u]].add(u);
        }
    }
    for (int d = 0; d < n; d++) {
        if (d0[d].size() > 1 || dn[d].size() > 1) {
            return cur;
        }
    }
    int ans = 0;
    for (int u = -1, d = 0; d < n; d++) {
        if (d0[d].size() > 0) {
            int v = d0[d].get(0);
            if (u >= 0) {
                int p = cur;
                p = min(p, dist0[u] + distn[u]);
                p = min(p, dist0[v] + distn[v]);
                p = min(p, dist0[u] + distn[v] + 1);
                p = min(p, dist0[v] + distn[u] + 1);
                ans = max(ans, p);
            }
            u = v;
        }
    }
    for (int u = -1, d = 0; d < n; d++) {
        if (dn[d].size() > 0) {
            int v = dn[d].get(0);
            if (u >= 0) {
                int p = cur;
                p = min(p, dist0[u] + distn[u]);
                p = min(p, dist0[v] + distn[v]);
                p = min(p, dist0[u] + distn[v] + 1);
                p = min(p, dist0[v] + distn[u] + 1);
                ans = max(ans, p);
            }
            u = v;
        }
    }
    return min(cur, ans);
}