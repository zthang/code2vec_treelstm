public void addVertex(T value, int weight) {
    if (!isInGraph(value)) {
        AdjVertex<T> vertex = new AdjVertex<T>(value, weight);
        map.put(value, vertex);
        vertex.setIndex(numberOfVertices);
        vertices.add(vertex);
        numberOfVertices++;
    }
}