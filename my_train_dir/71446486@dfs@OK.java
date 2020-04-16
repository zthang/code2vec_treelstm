static void dfs(int v) {
    used[v] = 1;
    for (edge to : gr[v]) {
        if (used[to.to] == 1) {
            col[to.id] = 2;
        } else {
            col[to.id] = 1;
            if (used[to.to] == 0)
                dfs(to.to);
        }
    }
    used[v] = 2;
}