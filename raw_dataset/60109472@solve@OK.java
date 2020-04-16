public void solve() {
    int n = io.readInt();
    int m = io.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
    }
    Edge[] edges = new Edge[m];
    for (int i = 0; i < m; i++) {
        edges[i] = new Edge();
        Node a = nodes[io.readInt()];
        edges[i].next = nodes[io.readInt()];
        a.edges.add(edges[i]);
    }
    cnt = m;
    color = 0;
    while (cnt > 0) {
        color++;
        for (int i = 1; i <= n; i++) {
            nodes[i].visited = false;
        }
        for (int i = 1; i <= n; i++) {
            dfs(nodes[i], null);
        }
    }
    io.cache.append(color).append('\n');
    for (Edge edge : edges) {
        io.cache.append(edge.c).append(' ');
    }
}