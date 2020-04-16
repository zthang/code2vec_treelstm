void dfs(int v) {
    used[v] = true;
    for (int to : graph[v]) {
        if (!used[to]) {
            dfs(to);
        }
    }
    mas.add(v);
}