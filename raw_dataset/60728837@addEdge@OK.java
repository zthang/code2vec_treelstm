public void addEdge(int from, int to) {
    g[from].add(new Graph.Edge(from, to));
    g[to].add(new Graph.Edge(to, from));
}