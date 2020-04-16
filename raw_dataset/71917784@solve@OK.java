static void solve() {
    n = in.nextInt();
    m = in.nextInt();
    g = new TreeSet[n];
    Arrays.setAll(g, gi -> new TreeSet<>());
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1;
        int u = in.nextInt() - 1;
        g[v].add(u);
        g[u].add(v);
    }
    unvis = new TreeSet<>();
    for (int v = 0; v < n; v++) {
        unvis.add(v);
    }
    int ans = 0;
    for (int v = 0; v < n; v++) {
        if (unvis.contains(v)) {
            unvis.remove(v);
            dfs(v);
            ans++;
        }
    }
    out.println(ans - 1);
}