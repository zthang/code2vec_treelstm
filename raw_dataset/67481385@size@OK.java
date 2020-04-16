public int size(int vertex) {
    int parent = getParent(vertex);
    return size[parent];
}