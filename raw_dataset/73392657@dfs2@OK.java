static void dfs2(int curr, int parent) {
    ans[curr] = dp[curr];
    for (int to : g.get(curr)) {
        if (to != parent) {
            dp[curr] -= Math.max(0, dp[to]);
            dp[to] += Math.max(0, dp[curr]);
            dfs2(to, curr);
            dp[to] -= Math.max(0, dp[curr]);
            dp[curr] += Math.max(0, dp[to]);
        }
    }
}