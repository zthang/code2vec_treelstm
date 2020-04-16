static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        n = ni();
        n *= 2;
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }
        subtree_size = new int[n + 1];
        for (int i = 1; i < n; ++i) {
            int u = ni(), v = ni(), w = ni();
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }
        max = min = 0;
        dfs(1, 1);
        pl(min + " " + max);
    }
    pw.flush();
    pw.close();
}