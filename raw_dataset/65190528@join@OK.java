static void join(int u, int v) {
    u = dsu(u);
    v = dsu(v);
    mx[min(u, v)] = max(mx[u], mx[v]);
    dsu[max(u, v)] = min(u, v);
}