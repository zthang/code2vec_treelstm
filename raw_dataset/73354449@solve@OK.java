static void solve() {
    n = in.nextInt();
    m = in.nextInt();
    sq = (int) Math.ceil(Math.sqrt(n));
    g = new ArrayList[n];
    Arrays.setAll(g, gg -> new ArrayList<>());
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1;
        int u = in.nextInt() - 1;
        g[v].add(u);
        g[u].add(v);
    }
    depth = new int[n];
    Arrays.fill(depth, -1);
    depth[0] = 0;
    p = new int[n];
    Arrays.fill(p, -1);
    p[0] = 0;
    set = new boolean[n];
    Arrays.fill(set, true);
    dfs(0);
    out.println(1);
    for (int v = 0, i = 0; v < n && i < sq; v++) {
        if (set[v]) {
            out.print((v + 1) + " ");
            i++;
        }
    }
    out.println();
}