static void dfs(int u, int[] used, int avoid) {
    used[u] = comp;
    for (int v : adj.get(u)) {
        if (used[v] != 0 || v == avoid)
            continue;
        dfs(v, used, avoid);
    }
}