private static int DFS(int u, int p, int[] solve) {
    int ans = (col[u] == 1) ? 1 : -1;
    for (int v : edge[u]) {
        if (v == p)
            continue;
        ans += Math.max(0, DFS(v, u, solve));
    }
    return solve[u] = ans;
}