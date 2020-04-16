public static int dfs(int u, int parent) {
    int ans = 0;
    for (int v : adj[u]) {
        if (v != parent) {
            ans += Math.max(0, dfs(v, u));
        }
    }
    return max[u] = ans + color[u];
}