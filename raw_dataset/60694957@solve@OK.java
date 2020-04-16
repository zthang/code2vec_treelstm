public void solve(int testNumber, InputReader in, PrintWriter out) {
    this.out = out;
    this.in = in;
    int n = ni();
    int k = ni();
    int i = 0;
    for (i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (i = 0; i < k; i++) {
        int u = ni() - 1;
        int v = ni() - 1;
        graph[u].add(v);
        graph[v].add(u);
    }
    int sum = 0;
    for (i = 0; i < n; i++) {
        if (!vis[i]) {
            sz = 0;
            dfs(i);
            sum += sz - 1;
        }
    }
    pn(k - sum);
}