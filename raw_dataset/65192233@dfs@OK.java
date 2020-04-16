void dfs(int v, int p) {
    E[v] = 1;
    S[v] = sc;
    B[sc][1] = Math.max(B[sc][1], v);
    B[sc][0] = Math.min(B[sc][0], v);
    for (int x = 0; x < A[v].size(); x++) {
        int u = A[v].get(x);
        if (u == p)
            continue;
        if (E[u] == 0)
            dfs(u, v);
    }
    E[v] = 2;
}