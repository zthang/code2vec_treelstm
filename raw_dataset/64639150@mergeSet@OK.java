static void mergeSet(int v, int u) {
    // u into v
    u = find(u);
    v = find(v);
    if (v == u)
        return;
    if (rank[v] < rank[u]) {
        int tmp = u;
        u = v;
        v = tmp;
    }
    par[u] = v;
    // if (rank[u]==rank[v])rank[v]++;
    rank[v] += rank[u];
}