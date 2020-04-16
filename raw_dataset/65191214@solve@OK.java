void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] from = new int[m], to = new int[m];
    DisJointSet dj = new DisJointSet(n);
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
        dj.union(from[i], to[i]);
    }
    int u = 0, edges = 0;
    while (u < n) {
        int cl = dj.root(u), mx = cl;
        for (int v = u + 1; v <= mx; v++) {
            if (dj.root(v) != dj.root(u)) {
                dj.union(u, v);
                mx = Math.max(mx, dj.root(u));
                edges++;
            }
        }
        u = mx + 1;
    }
    out.println(edges);
}