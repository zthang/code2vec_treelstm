void addEdge(int u, int v) {
    adj[u].add(new Edge(u, v, edges));
    adj[v].add(new Edge(v, u, edges++));
}