static int go(int mask) {
    // got to end
    if (mask + 1 == (1 << K))
        return 1;
    if (dp[mask] != -1)
        return dp[mask];
    // get first bit that's off
    int bit = -1;
    for (int i = 0; i < K; i++) {
        if ((mask & (1 << i)) == 0) {
            bit = i;
            break;
        }
    }
    int res = 0;
    // loop through things to take for this bit
    for (int take = 0; take < sz[bit]; take++) {
        int newMask = maskIfPick[bit][take];
        if (newMask == 0 || (mask & newMask) > 0)
            continue;
        res = (res | go(mask | newMask));
    }
    return dp[mask] = res;
}