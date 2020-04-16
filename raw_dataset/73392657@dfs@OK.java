static void dfs(int curr, int parent) {
    dp[curr] = A[curr];
    for (int to : g.get(curr)) {
        if (to != parent) {
            dfs(to, curr);
            dp[curr] += Math.max(0, dp[to]);
        }
    }
}