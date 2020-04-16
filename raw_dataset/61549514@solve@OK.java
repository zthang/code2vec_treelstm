static void solve(FastReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    can = true;
    g = new ArrayList[1 + n];
    Arrays.setAll(g, i -> new ArrayList<>());
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int v = in.nextInt();
        int u = in.nextInt();
        g[v].add(u);
        g[u].add(v);
        edges.add(new Edge(v, u));
    }
    set = new int[1 + n];
    Arrays.fill(set, 1, 1 + n, 1);
    for (int v : g[1]) {
        set[v] = 0;
    }
    for (int v = 1; v <= n; v++) {
        if (set[v] == 0) {
            set[v] = 2;
            dfs(v);
            break;
        }
    }
    if (!can) {
        out.println(-1);
        return;
    }
    boolean[] nonEmpty = new boolean[4];
    for (int v = 1; v <= n; v++) {
        nonEmpty[set[v]] = true;
    }
    if (nonEmpty[0] || !nonEmpty[1] || !nonEmpty[2] || !nonEmpty[3]) {
        out.println(-1);
        return;
    }
    for (Edge e : edges) {
        if (set[e.v] == set[e.u]) {
            out.println(-1);
            return;
        }
    }
    int[] cnt = new int[4];
    for (int v = 1; v <= n; v++) {
        cnt[set[v]]++;
    }
    for (int v = 1; v <= n; v++) {
        if (g[v].size() != cnt[1] + cnt[2] + cnt[3] - cnt[set[v]]) {
            out.println(-1);
            return;
        }
    }
    for (int v = 1; v <= n; v++) {
        out.print(set[v] + " ");
    }
    out.println();
}