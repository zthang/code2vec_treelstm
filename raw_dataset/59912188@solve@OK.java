private void solve(InputReader inp, PrintWriter out) {
    int n = inp.nextInt(), m = inp.nextInt();
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int u = inp.nextInt() - 1, v = inp.nextInt() - 1, w = inp.nextInt();
        edges.add(new Edge(u, v, w));
    }
    Collections.sort(edges);
    long[] dp = new long[200001];
    long[] size = new long[n];
    for (int i = 0; i < n; i++) size[i] = 1;
    DSU dsu = new DSU(n);
    int index = 0;
    for (int w = 1; w <= 200000; w++) {
        dp[w] = dp[w - 1];
        while (index < n - 1 && edges.get(index).w == w) {
            Edge e = edges.get(index);
            int u = e.u, v = e.v;
            int parentU = dsu.get(u), parentV = dsu.get(v);
            dp[w] -= size[parentU] * (size[parentU] - 1) / 2;
            dp[w] -= size[parentV] * (size[parentV] - 1) / 2;
            size[parentV] += size[parentU];
            dsu.union(u, v);
            dp[w] += size[parentV] * (size[parentV] - 1) / 2;
            index++;
        }
    }
    for (int i = 0; i < m; i++) {
        int q = inp.nextInt();
        out.print(dp[q] + " ");
    }
}