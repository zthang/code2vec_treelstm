static void solve() {
    n = in.nextInt();
    m = in.nextInt();
    g = new ArrayList[n];
    Arrays.setAll(g, gi -> new ArrayList<>());
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1;
        int u = in.nextInt() - 1;
        if (v > u) {
            g[v].add(u);
        } else {
            g[u].add(v);
        }
    }
    HashSet<Integer> comps = new HashSet<>();
    DSU dsu = new DSU(n);
    int[] cnt = new int[n];
    for (int v = 0; v < n; v++) {
        for (int u : g[v]) {
            cnt[dsu.find(u)]++;
        }
        for (Iterator<Integer> it = comps.iterator(); it.hasNext(); ) {
            int u = it.next();
            if (cnt[u] < dsu.size[u]) {
                it.remove();
                dsu.unite(v, u);
            }
            cnt[u] = 0;
        }
        comps.add(dsu.find(v));
    }
    HashSet<Integer> ans = new HashSet<>();
    for (int i = 0; i < n; i++) {
        ans.add(dsu.find(i));
    }
    out.println(ans.size() - 1);
}