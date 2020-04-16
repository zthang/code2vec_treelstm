private void addEdge(int x, int y) {
    nodes.get(x).addAdjacent(nodes.get(y));
    nodes.get(y).addAdjacent(nodes.get(x));
}