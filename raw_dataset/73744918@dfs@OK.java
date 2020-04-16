private static void dfs(int i) {
    dp[i] = A[i] == 1 ? 1 : -1;
    visited[i] = true;
    for (int n : neighbors.get(i)) if (!visited[n]) {
        dfs(n);
        dp[i] += Math.max(dp[n], 0);
    }
}