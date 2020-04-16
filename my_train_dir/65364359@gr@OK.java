public static int gr(int s, int e, int[][] a, int k, int[][] dp) {
    int t = 0;
    if (dp[s][k] != 0)
        return dp[s][k];
    if (s == e && k == 0) {
        dp[s][k] = 1;
        return 1;
    }
    if (k <= 0) {
        dp[s][k] = 0;
        return 0;
    }
    for (int i = 0; i < a[s].length; i++) {
        if (a[s][i] == 1) {
            t += gr(i, e, a, k - 1, dp);
        }
    }
    dp[s][k] = t;
    return t;
}