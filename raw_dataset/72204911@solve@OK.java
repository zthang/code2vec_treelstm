public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Graph g = new Graph(n);
    for (int i = 0; i < m; ++i) {
        int u = in.nextInt();
        int v = in.nextInt();
        g.addDirectedEdge(u, v, 1);
    }
    int k = in.nextInt();
    int[] p = in.nextIntArray(k);
    int[] dis = g.getMinDistanceTo(p[k - 1]);
    // for (int i = 0; i <= n; ++i) {
    // System.out.println(String.format("dis[%d]=%d", i, dis[i]));
    // }
    int mn = 0;
    int mx = 0;
    for (int i = 0; i < k - 1; ++i) {
        boolean hasMultipleShortPath = false;
        boolean coincideMin = false;
        int minDisFromCur = 1 << 30;
        int next = p[i + 1];
        int minNext = -1;
        for (Graph.Edge e : g.adj[p[i]]) {
            if (!e.enable)
                continue;
            int v = e.v;
            if (minDisFromCur > dis[v]) {
                minDisFromCur = dis[v];
                hasMultipleShortPath = false;
                coincideMin = (next == v);
            } else if (minDisFromCur == dis[v]) {
                hasMultipleShortPath = true;
                if (next == v)
                    coincideMin = true;
            }
        }
        // System.out.println(String.format("%d %s %s", p[i], coinsideMin, hasMultipleShortPath));
        if (coincideMin) {
            if (hasMultipleShortPath) {
                mx++;
            } else {
            }
        } else {
            mn++;
            mx++;
        }
    }
    out.println(mn + " " + mx);
}