private void addEdge(int x, int y, boolean undirected) {
    nodes[x].adjacents.add(nodes[y]);
    if (undirected) {
        nodes[y].adjacents.add(nodes[x]);
    }
}