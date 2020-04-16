static void dfs(int n, int p) {
    dp[n] = val[n];
    for (int i = 0; i < a[n].size(); i++) {
        int idx = (int) a[n].get(i);
        if (idx == p)
            continue;
        dfs(idx, n);
        dp[n] = Math.max(dp[n], dp[n] + dp[idx]);
    }
}