@SuppressWarnings("unchecked")
void solve(int testNumber, FastScanner s, PrintWriter out) {
    N = 2 * s.nextInt();
    sz = new int[N];
    dep = new int[N];
    edges = new int[3][N];
    Arrays.setAll(adj = new ArrayList[N], x -> new ArrayList<>());
    for (int u, v, w, i = 0; i < N - 1; i++) {
        u = s.nextInt() - 1;
        v = s.nextInt() - 1;
        w = s.nextInt();
        edges[0][i] = u;
        edges[1][i] = v;
        edges[2][i] = w;
        adj[u].add(v);
        adj[v].add(u);
    }
    dfs(0, -1, 0);
    long minTot = 0, maxTot = 0, w;
    for (int u, v, i = 0; i < N - 1; i++) {
        u = edges[0][i];
        v = edges[1][i];
        w = edges[2][i];
        // get sizes
        int a, b;
        if (dep[u] > dep[v]) {
            a = sz[u];
            b = N - a;
        } else {
            a = sz[v];
            b = N - a;
        }
        maxTot += w * (a < b ? a : b);
        minTot += (a & 1) * w;
    }
    out.printf("%d %d%n", minTot, maxTot);
}