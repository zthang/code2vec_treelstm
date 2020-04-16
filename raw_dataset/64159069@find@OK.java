private static int find(int source) {
    if (parent[source] == source)
        return source;
    return parent[source] = find(parent[source]);
}