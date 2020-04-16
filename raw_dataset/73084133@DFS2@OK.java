private static void DFS2(int u, int p, int[] solve) {
    if (u != 0) {
        if (solve[u] > 0)
            solve[u] = Math.max(solve[u], solve[p]);
        else
            solve[u] += Math.max(0, solve[p]);
    }
    for (int v : edge[u]) {
        if (v == p)
            continue;
        DFS2(v, u, solve);
    }
}