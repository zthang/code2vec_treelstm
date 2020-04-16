void solve() {
    int n = ni(), m = ni();
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    int[][] pars = parents3(g, 0);
    int[] par = pars[0], ord = pars[1], depth = pars[2];
    int[][] spar = logstepParents(par);
    inner: for (int q = 0; q < m; q++) {
        int K = ni();
        Integer[] a = new Integer[K];
        for (int i = 0; i < K; i++) a[i] = ni() - 1;
        if (K == 1) {
            out.println("YES");
        } else {
            Arrays.sort(a, (x, y) -> depth[x] - depth[y]);
            for (int i = K - 1; i >= 1; i--) {
                int lca = lca2(a[i], a[i - 1], spar, depth);
                if (lca == a[i - 1] || depth[lca] + 1 == depth[a[i - 1]])
                    continue;
                else {
                    out.println("NO");
                    continue inner;
                }
            }
            out.println("YES");
        }
    }
}