// 
static void dfs(int u) {
    // 
    if (vis[u] == 1)
        return;
    vis[u] = 1;
    for (int i = hed[u]; i != 0; i = nex[i]) {
        int v = mys[i];
        if (vis[v] == 0) {
            ans--;
            dfs(v);
        }
    }
}