public void solve(int testNumber, InputReader in, PrintWriter out) {
    int t = in.nextInt();
    for (int d = 0; d < t; d++) {
        n = in.nextInt();
        int m = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        as = new boolean[n + 1];
        bs = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            int u = in.nextInt();
            adj[v].add(u);
            adj[u].add(v);
        }
        dfs1(a);
        dfs2(b);
        long c1 = 0;
        long c2 = 0;
        as[a] = false;
        bs[b] = false;
        for (int i = 1; i <= n; i++) {
            if (as[i] && !bs[i])
                c1++;
            if (bs[i] && !as[i])
                c2++;
        }
        System.out.println(c1 * c2);
    }
}