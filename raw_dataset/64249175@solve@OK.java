static void solve() {
    int n = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.nextInt();
        y[i] = in.nextInt();
    }
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
        c[i] = in.nextInt();
    }
    int[] k = new int[n];
    for (int i = 0; i < n; i++) {
        k[i] = in.nextInt();
    }
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        edges.add(new Edge(0, i + 1, c[i]));
        for (int j = i + 1; j < n; j++) {
            long w = (long) (k[i] + k[j]) * (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
            edges.add(new Edge(i + 1, j + 1, w));
        }
    }
    Collections.sort(edges, (o1, o2) -> Long.compare(o1.w, o2.w));
    long yen = 0;
    ArrayList<Edge> ans = new ArrayList<>();
    DSU dsu = new DSU(n + 1);
    for (Edge e : edges) {
        int v = dsu.findSet(e.v);
        int u = dsu.findSet(e.u);
        if (v != u) {
            dsu.uniteSets(v, u);
            yen += e.w;
            ans.add(e);
        }
    }
    out.println(yen);
    int cnt0 = 0;
    for (Edge e : ans) {
        if (e.v == 0)
            cnt0++;
    }
    out.println(cnt0);
    for (Edge e : ans) {
        if (e.v == 0)
            out.print(e.u + " ");
    }
    out.println();
    out.println(ans.size() - cnt0);
    for (Edge e : ans) {
        if (e.v != 0)
            out.println(e.v + " " + e.u);
    }
}