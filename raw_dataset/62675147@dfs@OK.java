static void dfs(int v) {
    comp[v] = cnt;
    for (Integer to : g[v]) if (comp[to] == -1)
        dfs(to);
}