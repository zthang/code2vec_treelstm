void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] from = new int[m], to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
    }
    int[][] g = packU(n, from, to);
    int[][] nbr = new int[n][];
    int[] len = new int[n];
    for (int i = 0; i < n; i++) {
        nbr[i] = new int[g[i].length];
        for (int v : g[i]) {
            if (v > i) {
                nbr[i][len[i]++] = v;
            }
        }
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
        ans += len[i] * 1L * (g[i].length - len[i]);
    }
    out.println(ans);
    for (int q = scn.nextInt(); q > 0; q--) {
        int u = scn.nextInt() - 1;
        ans -= len[u] * 1L * (g[u].length - len[u]);
        for (int i = 0; i < len[u]; i++) {
            int v = nbr[u][i];
            ans -= len[v] * 1L * (g[v].length - len[v]);
            nbr[v][len[v]++] = u;
            ans += len[v] * 1L * (g[v].length - len[v]);
        }
        len[u] = 0;
        out.println(ans);
    }
}