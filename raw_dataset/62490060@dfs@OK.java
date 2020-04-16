void dfs(int v, int p) {
    path.add(v);
    for (int u : tree[v]) {
        if (u != p)
            dfs(u, v);
    }
}