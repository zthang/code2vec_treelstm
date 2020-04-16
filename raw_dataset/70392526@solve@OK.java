void solve(PrintWriter out, Reader in) throws IOException {
    t = in.nextInt();
    while (t-- > 0) {
        n = in.nextInt();
        dp = new int[n + 1][2];
        adj = new ArrayList[n + 1];
        child = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
            child[i] = new ArrayList<Integer>();
        }
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = in.nextInt();
            v = in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        DFS(1, 0);
        int ans = dp[1][0];
        for (int i = 2; i <= n; i++) {
            ans = Math.max(ans, dp[i][0] + 1);
        }
        out.println(ans);
    }
}