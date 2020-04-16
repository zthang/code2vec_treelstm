private void dfs1(int node, boolean[] vis, int dis) {
    vis[node] = true;
    dep[node] = dis;
    for (int nn : graph[node]) {
        if (!vis[nn]) {
            dfs1(nn, vis, dis + 1);
        }
    }
}