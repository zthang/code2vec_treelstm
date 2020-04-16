static long dp(int i, int j) {
    if (i >= n) {
        return 0;
    }
    if (j == x.length) {
        return INF;
    }
    if (memo[i][j] != -1) {
        return memo[i][j];
    }
    long ans = INF;
    if (c[i] == x[j]) {
        ans = Math.min(ans, dp(i + 1, j) + b[i]);
        ans = Math.min(ans, dp(i + 1, j + 1));
    } else {
        ans = Math.min(ans, dp(i + 1, j));
    }
    return memo[i][j] = ans;
}