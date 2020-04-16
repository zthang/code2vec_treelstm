public int maximumSum(int[] arr) {
    int n = arr.length;
    int[][] dp = new int[n][2];
    dp[0][0] = arr[0];
    int ret = arr[0];
    for (int i = 1; i < n; i++) {
        dp[i][0] = dp[i - 1][0] >= 0 ? (dp[i - 1][0] + arr[i]) : arr[i];
        int t1 = dp[i - 1][0];
        int t2 = (dp[i - 1][1] < 0 ? 0 : dp[i - 1][1]) + arr[i];
        dp[i][1] = Math.max(t1, t2);
        ret = Math.max(ret, Math.max(dp[i][0], dp[i][1]));
    }
    return ret;
}