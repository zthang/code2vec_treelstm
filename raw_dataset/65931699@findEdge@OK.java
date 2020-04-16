public Edge<T> findEdge(AdjVertex<T> vertex) {
    for (int i = 0; i < adjList.size(); i++) {
        if (adjList.get(i).getDestination() == vertex)
            return adjList.get(i);
    }
    return null;
}