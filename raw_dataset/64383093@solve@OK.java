void solve(int TC) throws Exception {
    int n = ni(), m = ni();
    int[] from = new int[m], to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = makeU(n, from, to);
    int min = 0;
    int[] set = new int[n];
    for (int i = 0; i < n; i++) set[i] = i;
    for (int i = 0; i < n; i++) if (g[i].length < g[min].length)
        min = i;
    Arrays.sort(g[min]);
    int p = 0;
    for (int i = 0; i < n; i++) {
        if (min == i)
            continue;
        if (p < g[min].length && g[min][p] == i)
            p++;
        else
            set[find(set, i)] = find(set, min);
    }
    for (int v : g[min]) {
        Arrays.sort(g[v]);
        p = 0;
        for (int i = 0; i < n; i++) {
            if (p < g[v].length && g[v][p] == i)
                p++;
            else
                set[find(set, i)] = find(set, v);
        }
    }
    int ans = -1;
    for (int i = 0; i < n; i++) if (find(set, i) == i)
        ans++;
    pn(ans);
}