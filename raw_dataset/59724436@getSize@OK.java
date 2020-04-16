public int getSize(int vertex) {
    vertex = parent[vertex];
    if (lists[vertex] == null) {
        return 1;
    }
    return lists[vertex].size() + 1;
}