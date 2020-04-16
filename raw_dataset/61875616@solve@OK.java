static void solve(FastReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    g = new ArrayList[n + 1];
    Arrays.setAll(g, i -> new ArrayList<>());
    adj = new int[n + 1];
    for (int i = 0; i < m; i++) {
        int v = in.nextInt();
        int u = in.nextInt();
        if (v > u)
            g[u].add(v);
        else
            g[v].add(u);
        adj[v]++;
        adj[u]++;
    }
    long trios = 0;
    for (int v = 1; v <= n; v++) {
        trios += (long) g[v].size() * (adj[v] - g[v].size());
    }
    out.println(trios);
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
        int v = in.nextInt();
        trios -= (long) g[v].size() * (adj[v] - g[v].size());
        for (int u : g[v]) {
            trios -= (long) g[u].size() * (adj[u] - g[u].size());
            g[u].add(v);
            trios += (long) g[u].size() * (adj[u] - g[u].size());
        }
        g[v].clear();
        out.println(trios);
    }
}