static void dfs(int v, int pr) {
    if (used[v]) {
        return;
    }
    comp[v] = sz;
    used[v] = true;
    for (int to : gr[v]) if (to != pr)
        dfs(to, v);
}