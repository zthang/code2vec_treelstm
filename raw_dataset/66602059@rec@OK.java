boolean rec(int mask, boolean[] hasCycle) {
    if (hasCycle[mask])
        return true;
    if (vis[mask] == true)
        return dp[mask];
    vis[mask] = true;
    for (int i = mask & (mask - 1); i > 0; i = mask & (i - 1)) {
        if (rec(i, hasCycle) && rec(i ^ mask, hasCycle)) {
            return dp[mask] = true;
        }
    }
    return dp[mask] = false;
}