static void dfs1(int start, int par, int d) {
    D[start] = d;
    L[start][0] = par;
    for (int i = 1; i < ln; i++) {
        L[start][i] = L[L[start][i - 1]][i - 1];
    }
    for (int u : graph[start]) {
        if (u == par)
            continue;
        dfs1(u, start, d + 1);
    }
}