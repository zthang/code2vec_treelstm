public static void dfs(int x) {
    if (marked[x]) {
        return;
    }
    marked[x] = true;
    for (int a : adj[x]) {
        dfs(a);
    }
}