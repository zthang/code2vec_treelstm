private static int dfs(int v, int p) {
    if (g[v].size() > 2) {
        errorfl = true;
        return 0;
    }
    for (int u : g[v]) {
        if (u != p) {
            int depth = dfs(u, v) + 1;
            int id = depth % 3;
            for (int i = 0; i < 6; i++) {
                paints[i][u] = indexes[i][id];
            }
            return depth;
        }
    }
    return 1;
}