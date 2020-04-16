public static void addEdge(int v, int u) {
    lis[v].add(u);
    lis[u].add(v);
}