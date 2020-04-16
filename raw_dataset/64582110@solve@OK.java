public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt(), k = in.nextInt();
    graph = Graphs.createGraph(n + 1);
    for (int i = 1; i <= k; ++i) {
        int u = in.nextInt(), v = in.nextInt();
        graph[u].add(v);
        graph[v].add(u);
    }
    int ans = 0;
    vis = new boolean[n + 1];
    for (int i = 1; i <= n; ++i) {
        if (!vis[i]) {
            ans += dfs(i) - 1;
        }
    }
    out.println(k - ans);
}