void dfs(int[][][] g, boolean[] vis, boolean[] edg, int u) {
    for (int[] v : g[u]) {
        if (!vis[v[0]]) {
            vis[v[0]] = true;
            edg[v[1]] = true;
            dfs(g, vis, edg, v[0]);
        }
    }
}