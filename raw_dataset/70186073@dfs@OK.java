void dfs(int v, int from, boolean flag) {
    colored[v] = flag;
    cnt[v][color[v]] = 1;
    cnt[v][color[v] ^ 1] = 0;
    for (Edge e : g[v]) {
        if (e.v != from) {
            if (e.flag == 1) {
                color[e.v] = color[v] ^ 1;
            } else {
                color[e.v] = color[v];
            }
            dfs(e.v, v, flag);
            cnt[v][0] += cnt[e.v][0];
            cnt[v][1] += cnt[e.v][1];
        }
    }
}