public void addEdge(int u, int v, boolean isDirected, long weight) {
    GraphUtils.Edge edge = new GraphUtils.Edge(nodes[u], nodes[v], weight);
    nodes[u].edges.add(edge);
    if (!isDirected) {
        GraphUtils.Edge edge1 = new GraphUtils.Edge(nodes[v], nodes[u], weight);
        nodes[v].edges.add(edge1);
    }
}