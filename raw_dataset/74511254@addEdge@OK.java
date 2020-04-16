private static void addEdge(int u, int v) {
    prev[++tot] = head[u];
    to[tot] = v;
    head[u] = tot;
}