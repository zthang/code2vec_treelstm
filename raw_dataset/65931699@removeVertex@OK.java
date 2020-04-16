public void removeVertex(T v) {
    if (isInGraph(v)) {
        removeVertex(searchVertex(v));
    }
}