public int find(int[] parent, int vertex) {
    // until an element is reached whose parent is itself
    if (parent[vertex] != vertex)
        return find(parent, parent[vertex]);
    ;
    return vertex;
}