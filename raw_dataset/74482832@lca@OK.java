static int lca(int p, int q) {
    if (depth[p] > depth[q]) {
        int tmp = p;
        p = q;
        q = tmp;
    }
    for (int k = 0; k < MAX_LOG_n; k++) {
        if ((((depth[q] - depth[p]) >> k) & 1) == 1) {
            q = parent[k][q];
        }
    }
    if (p == q)
        return p;
    for (int k = MAX_LOG_n - 1; k >= 0; k--) {
        if (parent[k][p] != parent[k][q]) {
            p = parent[k][p];
            q = parent[k][q];
        }
    }
    return parent[0][p];
}