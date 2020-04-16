public static void dfs(int cur) {
    color[cur] = 1;
    for (pair p : adj[cur]) {
        int to = p.u;
        int id = p.id;
        if (color[to] == 0) {
            ans[id] = 1;
            dfs(to);
        } else if (color[to] == 2) {
            ans[id] = 1;
        } else {
            cycle = true;
            ans[id] = 2;
        }
    }
    color[cur] = 2;
}