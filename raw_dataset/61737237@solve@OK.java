static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; ++i) {
        adj[ni()].add(new Pair(ni(), i));
    }
    ans = new int[m];
    state = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
        if (state[i] == 0) {
            dfs(i);
        }
    }
    int max = 0;
    for (int e : ans) {
        max = max(max, e);
    }
    pl(max + 1);
    for (int i = 0; i < m; ++i) {
        p(ans[i] + 1);
    }
    pl();
    pw.flush();
    pw.close();
}