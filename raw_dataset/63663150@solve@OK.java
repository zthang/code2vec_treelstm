static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni();
    vis = new boolean[n + 1];
    int k = ni();
    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < k; ++i) {
        int u = ni(), v = ni();
        adj[u].add(v);
        adj[v].add(u);
    }
    int satisfied = 0;
    for (int i = 1; i <= n; ++i) {
        if (!vis[i]) {
            szcc = 0;
            dfs(i);
            satisfied += szcc - 1;
        }
    }
    pl(k - satisfied);
    pw.flush();
    pw.close();
}