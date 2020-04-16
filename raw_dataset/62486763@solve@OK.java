static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    n = ni();
    c = new long[3][n];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < n; ++j) {
            c[i][j] = ni();
        }
    }
    adj = new ArrayList[n];
    for (int i = 0; i < n; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 1; i < n; ++i) {
        int u = ni(), v = ni();
        u--;
        v--;
        adj[u].add(v);
        adj[v].add(u);
    }
    int root = -1;
    for (int i = 0; i < n; ++i) {
        if (adj[i].size() > 2) {
            pl(-1);
            System.exit(0);
        }
        if (adj[i].size() == 1) {
            root = i;
        }
    }
    dfs(root, root);
    dp = new long[n][16];
    for (int i = 0; i < n; ++i) {
        Arrays.fill(dp[i], -1);
    }
    which = new int[n][16];
    color = new int[n + 1];
    pl(f(0, 0));
    int mask = 0, where = 0;
    while (where < n) {
        int node = nodes.get(where);
        color[node] = which[node][mask];
        mask = (mask % 4) * 4 + color[node];
        where++;
    }
    for (int i = 0; i < n; ++i) {
        p(color[i]);
    }
    pl();
    pw.flush();
    pw.close();
}