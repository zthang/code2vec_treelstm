public int getParent(int vertex) {
    int temp = vertex;
    while (parent[vertex] != vertex) {
        vertex = parent[vertex];
    }
    parent[temp] = vertex;
    return vertex;
}