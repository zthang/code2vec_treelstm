static void dfs(int v, int pr) {
    sz[v] = 1;
    for (int to : gr[v]) {
        if (to == pr)
            continue;
        dfs(to, v);
        sz[v] += sz[to];
    }
    for (int u = 0; u < gr[v].size(); u++) {
        int to = gr[v].get(u);
        int cost = c[v].get(u);
        if (to == pr)
            continue;
        if (sz[to] % 2 == 1)
            dp1[v] += cost;
        dp1[v] += dp1[to];
    }
    cnt[v]++;
    for (int u = 0; u < gr[v].size(); u++) {
        int to = gr[v].get(u);
        int cost = c[v].get(u);
        if (to == pr)
            continue;
        cnt[v] += cnt[to];
        dp2[v] += dp2[to] + cnt[to] * cost;
    }
    int other = n - sz[v];
    cnt[v] = Math.min(cnt[v], other);
}