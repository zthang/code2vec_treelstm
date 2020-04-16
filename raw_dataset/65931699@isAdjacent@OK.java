public boolean isAdjacent(AdjVertex<T> vertex) {
    for (int i = 0; i < adjList.size(); i++) {
        if (adjList.get(i).getDestination() == vertex)
            return true;
    }
    return false;
}