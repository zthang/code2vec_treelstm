void addEdge(int u, int v, long cost) {
    Edge e = new Edge(u, v, cost);
    Edge e1 = new Edge(v, u, cost);
    adj[u].add(e);
    adj[v].add(e1);
}