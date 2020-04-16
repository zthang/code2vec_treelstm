void dfs2(int v, int p, int q) {
    int a = E[q];
    D[v] = a;
    q++;
    if (q == 4)
        q = 1;
    for (int x = 0; x < A[v].size(); x++) {
        int u = A[v].get(x);
        if (u == p)
            continue;
        dfs2(u, v, q);
    }
}