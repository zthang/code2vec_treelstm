private static int getMin(boolean[] dp, int n) {
    for (int i = 1; i < n; i++) {
        if (!dp[i])
            return i;
    }
    return n;
}