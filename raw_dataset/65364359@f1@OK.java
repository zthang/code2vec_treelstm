public static int f1(int n, int[] v, int[] dp) {
    if (n == 0)
        return v[0];
    else if (n == 1)
        return Math.max(v[0], v[1]);
    if (dp[n] != 0)
        return dp[n];
    else {
        dp[n] = Math.max(f1(n - 2, v, dp) + v[n], f1(n - 1, v, dp));
        return dp[n];
    }
}