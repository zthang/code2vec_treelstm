static void dfs1(int v) {
    vis[v] = true;
    size_scc[counter]++;
    which[v] = counter;
    for (int e : radj[v]) {
        if (!vis[e]) {
            dfs1(e);
        }
    }
}