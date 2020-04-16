void func(int[][] g, int[] dp, int u, int p) {
    int max = 0, ch = 0;
    for (int v : g[u]) {
        if (v != p) {
            func(g, dp, v, u);
            ch++;
            max = Math.max(max, dp[v]);
        }
    }
    dp[u] = 1 + max + Math.max(ch - 1, 0);
}