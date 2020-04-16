public ArrayList<Edge<T>> getEdges() {
    ArrayList<Edge<T>> edges = new ArrayList<>();
    for (int i = 0; i < vertices.size(); i++) {
        AdjVertex<T> v = (AdjVertex<T>) vertices.get(i);
        for (int j = 0; j < v.getAdjList().size(); j++) {
            edges.add(v.getAdjList().get(j));
        }
    }
    return edges;
}