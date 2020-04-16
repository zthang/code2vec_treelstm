static void dfs2(int nd, int pr) {
    dp2[nd] = dp1[nd];
    if (pr != 0) {
        int val = dp2[pr] - Math.max(0, dp1[nd]);
        dp2[nd] += Math.max(0, val);
    }
    for (Integer ch : adj[nd]) {
        if (ch == pr)
            continue;
        dfs2(ch, nd);
    }
}