static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    DSU dsu = new DSU(n + 1);
    for (int i = 0; i < m; i++) {
        int v = in.nextInt();
        int u = in.nextInt();
        dsu.uniteSets(v, u);
    }
    int ans = 0;
    int v = 1;
    while (v <= n) {
        int v1 = dsu.findSet(v);
        int max = dsu.max[v1];
        for (int u = v + 1; u < max; u++) {
            v1 = dsu.findSet(v);
            int v2 = dsu.findSet(u);
            if (v1 != v2) {
                max = Math.max(max, dsu.max[v2]);
                dsu.uniteSets(v1, v2);
                ans++;
            }
        }
        v = max + 1;
    }
    out.println(ans);
}