void cal(int u, int pa) {
    dp[u][0] = dp[u][1] = 0;
    for (int v : al[u]) {
        if (val[v] > val[dp[u][0]]) {
            dp[u][1] = dp[u][0];
            dp[u][0] = v;
        } else if (val[v] > val[dp[u][1]]) {
            dp[u][1] = v;
        }
    }
    int nval = val[dp[u][0]] + val[dp[u][1]] + Math.max(0, al[u].size() - 2) + 1;
    // for(int i = 0; i < 2; i++){
    // int x = dp[u][i];
    // System.out.println(x + "-" + val[x]);
    // }
    // System.out.println(u + " " + nval);
    ans = Math.max(ans, nval);
    val[u] = val[dp[u][0]] + Math.max(0, al[u].size() - 2) + 1;
    int d = val[dp[u][1]] - val[dp[u][0]];
    for (int v : al[u]) {
        if (v == pa)
            continue;
        if (v == dp[u][0]) {
            val[u] += d;
        }
        cal(v, u);
        if (v == dp[u][0]) {
            val[u] -= d;
        }
    }
}