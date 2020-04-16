void solve() {
    int n = ni();
    long[] x = new long[n + 1];
    long[] y = new long[n + 1];
    for (int i = 1; i <= n; i++) {
        x[i] = nl();
        y[i] = nl();
    }
    c = new long[n + 1];
    long[] k = new long[n + 1];
    for (int i = 1; i <= n; i++) c[i] = nl();
    for (int i = 1; i <= n; i++) k[i] = nl();
    ArrayList<Node> edges = new ArrayList<>();
    sm = new long[n + 1];
    F = new int[n + 1];
    sz = new int[n + 1];
    par = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        sm[i] = 0;
        F[i] = i;
        sz[i] = 1;
        par[i] = i;
    }
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            edges.add(new Node(i, j, (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])) * (k[i] + k[j])));
        }
    }
    Collections.sort(edges);
    for (Node p : edges) {
        union(p.u, p.v, p.cost);
    }
    ArrayList<Integer> ans2 = new ArrayList<>();
    long total = 0;
    for (int i = 1; i <= n; i++) {
        if (i == root(i)) {
            ans2.add(par[i]);
            total += sm[i] + c[par[i]];
        }
    }
    pw.println(total);
    pw.println(ans2.size());
    for (int u : ans2) pw.print(u + " ");
    pw.println("");
    pw.println(ans.size());
    for (Node p : ans) pw.println(p.u + " " + p.v);
}