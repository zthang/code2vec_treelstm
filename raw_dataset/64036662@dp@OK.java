static long dp(int ff, int ss, int fir, int sec, int idx) {
    if (idx == s.length)
        return 1;
    if (memo[fir][sec][idx] != -1)
        return memo[fir][sec][idx];
    long ans = 0;
    return memo[fir][sec][idx] = ans;
}