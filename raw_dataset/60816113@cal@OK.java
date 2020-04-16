boolean cal(int u, int pa) {
    boolean r = sz[u] > 1;
    boolean ins = false;
    for (pair e : al[u]) {
        int v = e.F;
        if (v == pa)
            continue;
        ins = true;
        r |= cal(v, u);
        dp[u][1] += dp[v][1];
    }
    dp[u][0] = gmax;
    for (pair e : al[u]) {
        int v = e.F;
        if (v == pa)
            continue;
        dp[u][0] = Math.min(dp[u][0], dp[u][1] - dp[v][1] + dp[v][0]);
    }
    if (!r) {
        dp[u][1] += w[u];
    }
    if (!ins) {
        dp[u][0] = 0;
    }
    // System.out.println(u + " " + dp[u][0] + " " + dp[u][1] + " " + ins);
    return r;
}