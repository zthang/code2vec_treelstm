// Adds an edge to an undirected graph
void addEdge(int src, int dest) {
    // Add an edge from src to dest.
    adjListArray[src].add(dest);
    // Since graph is undirected, add an edge from dest
    // to src also
    adjListArray[dest].add(src);
}