static void addEdge(int src, int dest) {
    graph[src].add(dest);
    graph[dest].add(src);
}