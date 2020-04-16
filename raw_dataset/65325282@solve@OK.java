public static void solve(int n, int[] a, int m, FastIO io) {
    long[] dp = new long[n];
    long[] sum = new long[n];
    Arrays.sort(a);
    for (int i = 0; i < m; i++) sum[i] = a[i];
    for (int i = m; i < n; i++) sum[i] = a[i] + sum[i - m];
    dp[0] = a[0];
    for (int i = 1; i < n; i++) dp[i] = dp[i - 1] + sum[i];
    for (long i : dp) io.print(i + " ");
    io.println();
}