public int getNextVertex(int vertex, int previous) {
    for (int i = 0; i < graph[vertex].size(); i++) {
        if (graph[vertex].get(i) != previous) {
            return graph[vertex].get(i);
        }
    }
    return 0;
}