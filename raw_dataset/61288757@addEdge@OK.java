// Adds an edge to an undirected graph
static void addEdge(Graph graph, int src, int dest) {
    // Add an edge from src to dest.
    graph.adjListArray[src].add(dest);
    // Since graph is undirected, add an edge from dest
    // to src also
    graph.adjListArray[dest].add(src);
}