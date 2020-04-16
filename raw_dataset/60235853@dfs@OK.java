public static void dfs(int v) {
    mark[v] = 1;
    for (Edge e : adj[v]) {
        if (mark[e.b] == 0) {
            dfs(e.b);
        } else if (mark[e.b] == 1) {
            back[e.i] = true;
            cycle = true;
        }
    }
    mark[v] = 2;
}