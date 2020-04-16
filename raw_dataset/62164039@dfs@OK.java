void dfs(int[][] g, int[] sub, int u, int p, int anc) {
    int max = anc, max1 = 0, max2 = 0;
    for (int v : g[u]) {
        if (v != p) {
            max = Math.max(max, sub[v]);
            if (sub[v] > max1) {
                max2 = max1;
                max1 = sub[v];
            } else if (sub[v] > max2) {
                max2 = sub[v];
            }
        }
    }
    ans = Math.max(ans, max + g[u].length + Math.max(max2 - 1, 0));
    for (int v : g[u]) {
        if (v != p) {
            max = anc;
            if (sub[v] == max1) {
                max = Math.max(max2, max);
            } else {
                max = Math.max(max1, max);
            }
            int rv = max + Math.max(g[u].length - 1, 0);
            dfs(g, sub, v, u, rv);
        }
    }
}