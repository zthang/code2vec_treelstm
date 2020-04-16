static void dfsb(int i) {
    if (i == a) {
        vis[b][0] = 1;
        return;
    }
    if (vis[i][1] == 1)
        return;
    vis[i][1] = 1;
    for (int x : adj[i]) dfsb(x);
}