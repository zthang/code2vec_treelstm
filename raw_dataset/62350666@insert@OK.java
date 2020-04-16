void insert(int index, int s, int d) {
    s--;
    d--;
    Edge e = new Edge(index, s, d);
    adjList[s].add(e);
    edges.add(e);
}