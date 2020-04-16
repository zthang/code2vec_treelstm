private static void dfs2(int u, int p) {
    ans2[u] = ans[u];
    for (int v : g.get(u)) {
        if (v == p)
            continue;
        ans[u] -= (ans[v] >= 0 ? ans[v] : 0);
        ans[v] += (ans[u] >= 0 ? ans[u] : 0);
        dfs2(v, u);
        ans[v] -= (ans[u] >= 0 ? ans[u] : 0);
        ans[u] += (ans[v] >= 0 ? ans[v] : 0);
    }
}