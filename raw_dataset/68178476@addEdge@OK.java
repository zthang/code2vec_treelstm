static void addEdge(int a, int b) {
    if (g[a] == null)
        g[a] = new ArrayList<>();
    if (g[b] == null)
        g[b] = new ArrayList<>();
    g[a].add(b);
    g[b].add(a);
}