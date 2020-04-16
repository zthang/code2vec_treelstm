static void dfs(int ind) {
    vis[ind] = true;
    mx = Math.max(mx, ind);
    for (int i : adj[ind]) {
        if (!vis[i]) {
            dfs(i);
        }
    }
}