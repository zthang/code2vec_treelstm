void solve() {
    n = in.nextInt();
    m = in.nextInt();
    long ans = 0;
    for (int i = 1; i <= n; i++) {
        ans += w[i] = in.nextInt();
        al[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int u = in.nextInt(), v = in.nextInt();
        from[i] = u;
        to[i] = v;
        al[u].add(new pair(v, i));
        al[v].add(new pair(u, i));
    }
    dfs(1, 0);
    for (int i = 1; i <= n; i++) pa[i] = i;
    for (int i = 0; i < m; i++) {
        if (!b[i]) {
            int u = from[i], v = to[i];
            int pu = get(u), pv = get(v);
            if (pu != pv)
                merge(pu, pv);
        }
    }
    for (int i = 1; i <= n; i++) al[i].clear();
    for (int i = 1; i <= n; i++) {
        pa[i] = get(i);
        // System.out.print(pa[i] + " ");
        if (pa[i] != i)
            w[pa[i]] += w[i];
        sz[pa[i]]++;
    }
    for (int i = 0; i < m; i++) {
        if (b[i]) {
            int u = from[i], v = to[i];
            al[pa[u]].add(new pair(pa[v], -1));
            al[pa[v]].add(new pair(pa[u], -1));
        }
    }
    int x = in.nextInt();
    int s = pa[x];
    cal(s, 0);
    ans -= Math.min(dp[s][0], dp[s][1]);
    out.print(ans);
}