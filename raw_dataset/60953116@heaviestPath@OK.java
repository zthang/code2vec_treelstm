private long heaviestPath(int v, int p) {
    long res = 0;
    for (int u : adj[v]) {
        if (u != p) {
            res = Math.max(res, heaviestPath(u, v));
        }
    }
    return res + w[v];
}