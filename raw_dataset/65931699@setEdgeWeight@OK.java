public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w) {
    if (isInGraph(x.getValue()) && isInGraph(y.getValue()) && weighted) {
        AdjVertex<T> from = (AdjVertex<T>) x;
        AdjVertex<T> to = (AdjVertex<T>) y;
        Edge<T> e = from.findEdge(to);
        if (e != null)
            e.setWeight(w);
        if (!isDirected()) {
            e = to.findEdge(from);
            if (e != null)
                e.setWeight(w);
        }
    }
}