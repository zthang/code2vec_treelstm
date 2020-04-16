static boolean dfs(int ind, int a) {
    vis[ind] = true;
    c++;
    boolean f = true;
    if (ind == a) {
        f = false;
    }
    for (int i : adj[ind]) {
        if (!vis[i]) {
            f &= dfs(i, a);
        }
    }
    return f;
}