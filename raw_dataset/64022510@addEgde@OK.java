public void addEgde(int source, int destination, long weight) {
    Edge edge = new Edge(source, destination, weight);
    // add to total edges
    allEdges.add(edge);
}