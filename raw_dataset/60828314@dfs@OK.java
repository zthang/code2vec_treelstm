void dfs(int v) {
    col[v] = 1;
    for (Edge e : g[v]) {
        if (col[e.to] == 0) {
            ans[e.id] = 1;
            dfs(e.to);
        } else if (col[e.to] == 2) {
            ans[e.id] = 1;
        } else {
            ans[e.id] = 2;
            one = false;
        }
    }
    col[v] = 2;
}