public double getEdgeWeight(Vertex<T> x, Vertex<T> y) {
    double w = 0;
    if (isInGraph(x.getValue()) && isInGraph(y.getValue())) {
        AdjVertex<T> from = (AdjVertex<T>) x;
        AdjVertex<T> to = (AdjVertex<T>) y;
        Edge<T> e = from.findEdge(to);
        if (e != null)
            w = e.getWeight();
    }
    return w;
}