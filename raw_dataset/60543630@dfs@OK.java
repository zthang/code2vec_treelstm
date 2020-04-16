void dfs(int i) {
    u[i] = true;
    for (int j : g[i]) {
        if (!u[j]) {
            dfs(j);
        }
    }
}