public static void dfs(int node) {
    visited[node] = true;
    for (int x : graph[node]) {
        if (!visited[x]) {
            dfs(x);
        }
    }
    topoSort.addFirst(node);
}