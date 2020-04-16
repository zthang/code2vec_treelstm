void dfs(int x, int fa) {
    // System.out.println(x);
    for (int t : g[x]) {
        if (t == fa)
            continue;
        dfs(t, x);
        h[x].addAll(h[t]);
    }
    if (c[x] > h[x].size())
        ok = 0;
    if (ok > 0)
        h[x].add(c[x], x);
}