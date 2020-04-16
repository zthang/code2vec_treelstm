public static void dfs(int i) {
    marked[i] = true;
    curr++;
    for (int v : adj[i]) {
        if (!marked[v]) {
            dfs(v);
        }
    }
}