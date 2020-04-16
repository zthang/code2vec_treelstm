long[] dfs(int[][][] g, long[] w, int[] sub, int u, int p) {
    long[] ans = new long[] { 0, 0 };
    sub[u] = 1;
    for (int[] v : g[u]) {
        if (v[0] == p)
            continue;
        long[] a = dfs(g, w, sub, v[0], u);
        sub[u] += sub[v[0]];
        ans[0] += a[0];
        ans[1] += a[1];
        if (sub[v[0]] % 2 == 1)
            ans[0] += w[v[1]];
        ans[1] += Math.min(sub[v[0]], g.length - sub[v[0]]) * w[v[1]];
    }
    return ans;
}