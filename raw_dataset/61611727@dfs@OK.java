static void dfs(int ind, int c) {
    vis[ind] = true;
    boolean f = true;
    if (col[ind] != 0)
        f = false;
    for (int i : adj[ind]) {
        if (col[i] == c)
            f = false;
    }
    if (f) {
        col[ind] = c;
        cnt[c]++;
    }
    for (int i : adj[ind]) {
        if (!vis[i])
            dfs(i, c);
    }
}