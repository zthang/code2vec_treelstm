void solve() {
    int n = ni(), m = ni();
    g = new ArrayList[n + 1];
    grev = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        g[i] = new ArrayList<>();
        grev[i] = new ArrayList<>();
    }
    while (m-- > 0) {
        int u = ni(), v = ni();
        g[u].add(v);
        grev[v].add(u);
    }
    int k = ni();
    int[] p = new int[k + 1];
    for (int i = 1; i <= k; i++) p[i] = ni();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[p[k]] = 0;
    q.offer(new Node(p[k], 0));
    while (!q.isEmpty()) {
        Node nd = q.poll();
        for (int u : grev[nd.v]) {
            if (dp[nd.v] + 1 < dp[u]) {
                dp[u] = dp[nd.v] + 1;
                q.offer(new Node(u, dp[u]));
            }
        }
    }
    int mn = 0, mx = 0;
    for (int i = 1; i < k; i++) {
        for (int u : g[p[i]]) {
            if (dp[p[i]] - 1 == dp[u] && p[i + 1] != u) {
                mx++;
                break;
            }
        }
        if (dp[p[i]] - 1 != dp[p[i + 1]])
            mn++;
    }
    pw.println(mn + " " + mx);
}