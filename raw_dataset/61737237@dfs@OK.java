static void dfs(int v) {
    state[v] = 1;
    for (Pair p : adj[v]) {
        if (state[p.x] == 0) {
            dfs(p.x);
        } else if (state[p.x] == 1) {
            ans[p.y] = 1;
        }
    }
    state[v] = 2;
}