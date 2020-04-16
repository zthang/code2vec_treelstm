static void union(int u, int v) {
    u = find(u);
    v = find(v);
    if (u > v) {
        int temp = u;
        u = v;
        v = temp;
    }
    id[v] = u;
    ans -= calc(sizes[u]);
    ans -= calc(sizes[v]);
    ans += calc(sizes[u] + sizes[v]);
    sizes[u] += sizes[v];
}