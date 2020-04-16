public static void union(int a, int b) {
    int u = Math.min(a, b);
    int v = Math.max(a, b);
    u = getParent(u);
    v = getParent(v);
    a = Math.min(u, v);
    b = Math.max(u, v);
    parent[b] = a;
    max[a] = Math.max(max[a], max[b]);
}