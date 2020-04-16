void dfs(int u, int pa) {
    for (int v : al[u]) {
        if (v == pa)
            continue;
        dfs(v, u);
        if (val[v] > val[dp[u][0]]) {
            dp[u][0] = v;
        }
    }
    val[u] = val[dp[u][0]] + Math.max(0, al[u].size() - 2) + 1;
}