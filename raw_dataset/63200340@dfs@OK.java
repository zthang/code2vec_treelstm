static void dfs(int v, int p, int color) {
    col[v] = color;
    for (Integer to : g[v]) {
        if (to != p)
            dfs(to, v, 3 - col[v] - col[p]);
    }
}