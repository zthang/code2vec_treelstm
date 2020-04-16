void dfs(int u, int par) {
    array.add(u);
    for (int v : l[u]) {
        if (v == par)
            continue;
        dfs(v, u);
    }
}