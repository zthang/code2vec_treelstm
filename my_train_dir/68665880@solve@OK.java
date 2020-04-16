public void solve(int testNumber, FastReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    edge = new TreeSet[n + 1];
    // not visited
    vx = new TreeSet<>();
    for (int i = 1; i <= n; ++i) {
        edge[i] = new TreeSet<>();
        vx.add(i);
    }
    for (int i = 1; i <= m; ++i) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        edge[u].add(v);
        edge[v].add(u);
    }
    int comp = 0;
    for (int i = 1; i <= n; ++i) {
        if (vx.contains(i)) {
            dfs(i);
            ++comp;
        }
    }
    out.println(comp - 1);
}