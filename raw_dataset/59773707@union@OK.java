public static void union(int v, int u) {
    v = findParent(v);
    u = findParent(u);
    if (v == u) {
        return;
    }
    if (random.nextInt(2) == 1) {
        parent[v] = u;
        rank[u] += rank[v];
    } else {
        parent[u] = v;
        rank[v] += rank[u];
    }
}