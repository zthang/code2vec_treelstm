static long dfs(int u, int currCol, int parCol, int p, boolean con) {
    long ans = col[u][currCol];
    if (con)
        Ans[u] = currCol;
    for (int v : adj[u]) if (v != p)
        ans += dfs(v, 3 - currCol - parCol, currCol, u, con);
    return ans;
}