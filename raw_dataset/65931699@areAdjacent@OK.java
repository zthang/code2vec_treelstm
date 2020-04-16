public boolean areAdjacent(Vertex<T> x, Vertex<T> y) {
    return getNeighbors(x).contains(y);
}