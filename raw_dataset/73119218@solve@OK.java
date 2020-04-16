public static void solve() {
    int n = s.nextInt();
    color = new int[n];
    for (int i = 0; i < n; i++) {
        color[i] = s.nextInt();
    }
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<Integer>();
    }
    for (int i = 0; i < n - 1; i++) {
        int u = s.nextInt() - 1;
        int v = s.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    dp = new int[n];
    dp2 = new int[n];
    dfs(0, -1);
    dp2[0] = dp[0];
    for (Integer x : adj[0]) {
        dfs1(x, 0);
    }
    for (int i = 0; i < n; i++) {
        out.print(dp2[i] + " ");
    }
}