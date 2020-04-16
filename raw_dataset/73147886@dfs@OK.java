static void dfs(int s, int p) {
    dp[s] = color[s];
    for (Integer x : graph[s]) {
        if (x == p)
            continue;
        dfs(x, s);
        dp[s] += Math.max(0, dp[x]);
    }
}