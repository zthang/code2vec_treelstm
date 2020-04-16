static int go(int which, int st) {
    if (st >= N)
        return 0;
    if (dp[which][st] != -1)
        return dp[which][st];
    int res = 0;
    for (int r = st; r < N; r++) {
        res = max(res, take(which, st, r) + go(which ^ 1, r + 1));
    }
    return dp[which][st] = res;
}