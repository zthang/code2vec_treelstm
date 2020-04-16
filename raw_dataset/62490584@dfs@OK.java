long dfs(int v, int p, int q) {
    int a = C[q];
    long r = B[v][a];
    q++;
    if (q == 4)
        q = 1;
    for (int x = 0; x < A[v].size(); x++) {
        int u = A[v].get(x);
        if (u == p)
            continue;
        r += dfs(u, v, q);
    }
    return r;
}