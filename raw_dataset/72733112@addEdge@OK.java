static void addEdge(int src, int dest) {
    graph[src].add(dest);
    graphT[dest].add(src);
}