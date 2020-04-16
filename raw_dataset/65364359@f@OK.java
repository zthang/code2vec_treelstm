public static int f(int n, int k, int[] v, int[][] dp) {
    if (n == 0)
        return 0;
    if (n < 0 || k <= 0)
        return -1;
    if (dp[n][k] != 0) {
        return dp[n][k];
    }
    int c = f(n - k, k, v, dp);
    if (c == -1) {
        dp[n][k] = f(n, k - 1, v, dp);
    } else {
        dp[n][k] = Math.max(c + v[k - 1], f(n, k - 1, v, dp));
    }
    return dp[n][k];
}