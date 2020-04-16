static void dfsa(int i) {
    if (i == b) {
        vis[a][1] = 1;
        return;
    }
    if (vis[i][0] == 1)
        return;
    vis[i][0] = 1;
    for (int x : adj[i]) dfsa(x);
}