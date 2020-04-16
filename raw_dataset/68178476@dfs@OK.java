static void dfs(int i) {
    used[i] = true;
    for (int to : g[i]) {
        if (!used[to])
            dfs(to);
    }
}