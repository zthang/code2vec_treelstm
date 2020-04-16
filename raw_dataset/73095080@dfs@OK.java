private static void dfs(int u, int p) {
    ans[u] = (color[u] == 1 ? 1 : -1);
    for (int v : g.get(u)) {
        if (v == p)
            continue;
        dfs(v, u);
        ans[u] += (ans[v] >= 0 ? ans[v] : 0);
    }
}