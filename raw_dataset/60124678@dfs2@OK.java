boolean dfs2(int p, int c, int[] D) {
    boolean f = true;
    D[p] = 1;
    for (int x = 0; x < A[p].size(); x++) {
        if (C[p].get(x) < c)
            continue;
        int q = A[p].get(x);
        if (D[q] == 2)
            continue;
        if (D[q] == 1) {
            f = false;
            C[p].set(x, c + 1);
            continue;
        }
        if (!dfs2(q, c, D))
            f = false;
    }
    D[p] = 2;
    return f;
}