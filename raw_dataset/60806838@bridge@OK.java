boolean[] bridge(int[][][] g, int m) {
    int n = g.length;
    boolean[] vis = new boolean[n], ans = new boolean[m];
    int[] disc = new int[n], low = new int[n];
    Arrays.fill(low, INF);
    for (int i = 0; i < n; i++) if (!vis[i] && g[i] != null)
        bridgeUtil(g, ans, vis, disc, low, i, -1, 0);
    return ans;
}