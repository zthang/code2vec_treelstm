static void dfs(int ind, int j) {
    vis[ind] = true;
    arr[j] = ind;
    for (int i : adj[ind]) {
        if (!vis[i]) {
            dfs(i, j + 1);
        }
    }
}