static void dfs(int a) {
    visited[a] = true;
    min = Math.min(min, a);
    max = Math.max(max, a);
    for (int i : graph[a].edges) {
        if (!visited[i]) {
            dfs(i);
        }
    }
}