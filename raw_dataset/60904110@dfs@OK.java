static void dfs(int cur, int p) {
    ll[cur] = cnt++;
    pre[cur] = ll[cur];
    for (Edge edge : graph[cur]) {
        int u = edge.getOther(cur);
        if (u == p)
            continue;
        if (pre[u] == -1) {
            dfs(u, cur);
            ll[cur] = Math.min(ll[cur], ll[u]);
        } else {
            ll[cur] = Math.min(ll[cur], pre[u]);
        }
        if (ll[u] > pre[cur])
            edge.isBridge = true;
    }
}