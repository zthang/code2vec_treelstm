private int dfs(List<Integer>[] edges, int v, int n) {
    int max = 0;
    if (v >= n) {
        int ans = check(edges, n);
        return Math.max(ans, max);
    }
    for (int i = 1; i <= 6; i++) {
        vis[v] = i;
        max = Math.max(max, dfs(edges, v + 1, n));
    }
    return max;
}