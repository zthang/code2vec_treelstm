public List<Vertex<T>> getNeighbors(Vertex<T> x) {
    List<Vertex<T>> neigh = new ArrayList<>();
    AdjVertex<T> from = (AdjVertex<T>) x;
    List<Edge<T>> adj = from.getAdjList();
    for (int i = 0; i < adj.size(); i++) {
        neigh.add(adj.get(i).getDestination());
    }
    return neigh;
}