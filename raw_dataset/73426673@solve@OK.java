public static void solve(int u) {
    if (down[u] == -1) {
        ans[u] = Math.max(down[u], -1 + (p[u] == -1 ? 0 : ans[p[u]]));
    } else
        ans[u] = Math.max(down[u], (p[u] == -1 ? 0 : ans[p[u]]));
    for (int x : adjList[u]) {
        if (x != p[u]) {
            solve(x);
        }
    }
}