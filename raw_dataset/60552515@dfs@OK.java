public static void dfs(int v) {
    visited[v] = true;
    for (int i : adj.get(v)) if (!visited[i])
        dfs(i);
}