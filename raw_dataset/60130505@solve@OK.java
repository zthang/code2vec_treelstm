void solve() {
    int n = ni(), m = ni();
    g = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
    Node[] p = new Node[m + 1];
    for (int i = 1; i <= m; i++) {
        int u = ni(), v = ni();
        g[u].add(new Node(v, i));
        p[i] = new Node(u, v);
    }
    color = new int[m + 1];
    vis = new int[n + 1];
    Arrays.fill(color, -1);
    cycle = false;
    for (int i = 1; i <= n; i++) {
        if (vis[i] == 0)
            dfs(i);
    }
    if (!cycle) {
        pw.println("1");
        for (int i = 1; i <= m; i++) pw.print("1 ");
        pw.println("");
        return;
    }
    pw.println("2");
    for (int i = 1; i <= m; i++) {
        if (p[i].v < p[i].id)
            pw.print("1 ");
        else
            pw.print("2 ");
    }
}