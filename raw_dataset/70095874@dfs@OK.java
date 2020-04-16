static void dfs(int v) {
    for (Pair p : adj[v]) {
        if (color[p.x] == -1) {
            color[p.x] = (color[v] ^ p.y);
            dfs(p.x);
        }
    }
}