public void addEdge(AdjVertex<T> from, AdjVertex<T> to, double w) {
    if (from != null && to != null) {
        Edge<T> edge = new Edge<T>(from, to, w);
        from.getAdjList().add(edge);
        if (!isDirected()) {
            edge = new Edge<T>(to, from, w);
            to.getAdjList().add(edge);
        }
        numberOfEdges++;
    }
}