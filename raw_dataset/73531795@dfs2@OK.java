static void dfs2(int nd, int pr) {
    dp2[nd] = dp1[nd];
    if (pr != -1) {
        // contribution of nd to par
        int val = dp2[pr] - Math.max(0, dp1[nd]);
        dp2[nd] += Math.max(0, val);
    }
    for (Object ch : adj[nd]) {
        if ((int) ch != pr)
            dfs2((int) ch, nd);
    }
}