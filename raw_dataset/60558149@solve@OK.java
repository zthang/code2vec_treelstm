void solve() {
    N = ni();
    int K = ni();
    n = N + K;
    g = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
    for (int i = 1; i <= K; i++) {
        int x = ni(), y = ni();
        g[x].add(N + i);
        g[N + i].add(x);
        g[y].add(N + i);
        g[N + i].add(y);
    }
    vis = new int[n + 1];
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (vis[i] == 1)
            continue;
        cc = 0;
        dfs(i);
        if (cc > 0)
            ans += cc - 1;
    }
    pw.println(K - ans);
}