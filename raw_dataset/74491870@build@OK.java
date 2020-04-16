public void build(int u) {
    dfs(u, -1, 0);
    for (int j = 1; j < LOG; j++) for (int i = 0; i < n; i++) {
        par[i][j] = -1;
        if (par[i][j - 1] != -1)
            par[i][j] = par[par[i][j - 1]][j - 1];
    }
}