void dfs(int i, int id) {
    if (vis[i])
        return;
    vis[i] = true;
    grp[id].add(i);
    for (int k : adj[i]) {
        dfs(k, id);
    }
}