static void dfs1(int i, int p) {
    for (int j : arr[i]) {
        if (j != p) {
            if (dp[j] < 0) {
                dp[j] += Math.max(0, dp[i]);
            } else {
                dp[j] += Math.max(0, dp[i] - dp[j]);
            }
            dfs1(j, i);
        }
    }
}