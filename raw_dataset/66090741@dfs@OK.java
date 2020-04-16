static void dfs(int start) {
    if (marked[start])
        return;
    marked[start] = true;
    for (int next : adj[start]) {
        dfs(next);
    }
}