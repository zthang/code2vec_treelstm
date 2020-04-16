public void removeEdge(T x, T y) {
    if (isInGraph(x) && isInGraph(y)) {
        removeEdge(searchVertex(x), searchVertex(y));
    }
}