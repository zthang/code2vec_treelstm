long[] dfs(int[][] g, boolean[] sp, long[] w, int u, int p) {
    long[] ret = new long[2];
    long mx = 0;
    for (int v : g[u]) {
        if (v == p)
            continue;
        long[] val = dfs(g, sp, w, v, u);
        mx = Math.max(mx, val[0] - val[1]);
        ret[1] += val[1];
        sp[u] |= sp[v];
    }
    ret[0] = ret[1] + mx;
    ret[0] += w[u];
    if (sp[u])
        ret[1] += w[u];
    return ret;
}