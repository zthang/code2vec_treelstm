void addEdge(int v1, int v2) {
    edges[v1].add(v2);
    edges[v2].add(v1);
}