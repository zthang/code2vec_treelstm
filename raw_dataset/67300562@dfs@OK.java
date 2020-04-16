void dfs(int v) {
    used[v] = true;
    for (Integer c : graph[v]) {
        if (!used[c])
            dfs(c);
    }
}