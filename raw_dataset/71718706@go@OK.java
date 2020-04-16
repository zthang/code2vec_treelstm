static long go(int k, int n) {
    if (k == 0)
        return n == 0 ? 0 : INF;
    if (ver[k][n] == iter)
        return dp[k][n];
    long res = INF;
    if (c[n]) {
        for (int ii : blue) res = min(res, d[n][ii] + go(k - 1, ii));
    } else {
        for (int ii : red) res = min(res, d[n][ii] + go(k - 1, ii));
    }
    ver[k][n] = iter;
    return dp[k][n] = res;
}