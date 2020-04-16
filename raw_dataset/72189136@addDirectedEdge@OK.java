public void addDirectedEdge(int u, int v, int value) {
    adj[u].add(new Edge(v, value));
    Edge e = new Edge(u, value);
    e.enable = false;
    adj[v].add(e);
}