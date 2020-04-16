public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt(), k = in.nextInt();
    Graph g = new Graph(n);
    for (int i = 0; i < k; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        g.addEdge(u, v);
    }
    int edgesExplored = 0;
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            edgesExplored += dfs(g, i, -1, vis);
        }
    }
    int ans = k - edgesExplored;
    out.println(ans);
}