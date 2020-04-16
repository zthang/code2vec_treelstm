public static void union(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v)
        return;
    if (h[u] > h[v])
        par[v] = u;
    else if (h[v] > h[u])
        par[u] = v;
    else {
        h[u] += 1;
        par[v] = u;
    }
    min[u] = min[v] = Math.min(min[u], min[v]);
}