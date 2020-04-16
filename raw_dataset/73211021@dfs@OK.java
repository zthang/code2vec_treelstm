private void dfs(List<int[]>[] g, boolean[] vn, int[] ans, int u) {
    vn[u] = true;
    for (int[] ne : g[u]) {
        if (ans[ne[1]] > 0)
            continue;
        if (!vn[ne[0]]) {
            ans[ne[1]] = 1;
            dfs(g, vn, ans, ne[0]);
        } else {
            max = 2;
            ans[ne[1]] = 2;
        }
    }
    vn[u] = false;
}