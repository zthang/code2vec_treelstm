void dfs(int[][] g, int[] need, int[] dp, int u, int p, int anc) {
    int max = anc, max1 = 0, max2 = 0;
    for (int v : g[u]) {
        if (v != p) {
            max = Math.max(max, need[v]);
            if (need[v] > max1) {
                max2 = max1;
                max1 = need[v];
            } else if (need[v] > max2) {
                max2 = need[v];
            }
        }
    }
    dp[u] = max + g[u].length + Math.max(max2 - 1, 0);
    for (int v : g[u]) {
        if (v != p) {
            max = anc;
            if (need[v] == max1) {
                max = Math.max(max2, max);
            } else {
                max = Math.max(max1, max);
            }
            int rv = max + Math.max(g[u].length - 1, 0);
            dfs(g, need, dp, v, u, rv);
        }
    }
}