public ArrayList<Edge<T>> kruskal() {
    ArrayList<Edge<T>> result = new ArrayList<>();
    int e = 0;
    int i = 0;
    ArrayList<Edge<T>> edges = getEdges();
    Collections.sort(edges);
    UnionFind uf = new UnionFind(vertices.size());
    i = 0;
    while (e < vertices.size() - 1 && i < edges.size()) {
        Edge<T> edge = edges.get(i);
        i++;
        int x = uf.find(getIndexOf(edge.getSource()));
        int y = uf.find(getIndexOf(edge.getDestination()));
        if (x != y) {
            result.add(edge);
            e++;
            uf.union(x, y);
        }
    }
    return result;
}