private static int DFS(int u, int p, int[] solve) {
    int ans = (col[u] == 1) ? 1 : -1;
    for (int i = 0; i < edge[u].size(); i++) {
        int v = edge[u].get(i);
        if (v == p)
            continue;
        int tmp = val[u].get(i);
        if (tmp == INF)
            tmp = DFS(v, u, solve);
        val[u].set(i, tmp);
        ans += Math.max(tmp, 0);
    }
    return solve[u] = ans;
}