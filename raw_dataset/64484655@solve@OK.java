static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    HashSet<Integer>[] g = new HashSet[n + 1];
    Arrays.setAll(g, i -> new HashSet<>());
    for (int i = 0; i < m; i++) {
        int v = in.nextInt();
        int u = in.nextInt();
        g[v].add(u);
        g[u].add(v);
    }
    int v = 1;
    for (int i = 2; i <= n; i++) {
        if (g[i].size() < g[v].size())
            v = i;
    }
    DSU dsu = new DSU(n + 1);
    for (int i = 1; i <= n; i++) {
        if (i == v)
            continue;
        if (!g[v].contains(i)) {
            dsu.uniteSets(v, i);
        } else {
            for (int j = 1; j <= n; j++) {
                if (j == i)
                    continue;
                if (!g[i].contains(j)) {
                    dsu.uniteSets(i, j);
                }
            }
        }
    }
    HashSet<Integer> ans = new HashSet<>();
    for (int i = 1; i <= n; i++) {
        ans.add(dsu.findSet(i));
    }
    out.print(ans.size() - 1);
}