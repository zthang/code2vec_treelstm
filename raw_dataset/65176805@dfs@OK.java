void dfs(int v, int _which) {
    vis[v] = true;
    which[v] = _which;
    hola[_which].add(v);
    for (int u : graph[v]) {
        if (!vis[u])
            dfs(u, _which);
    }
}