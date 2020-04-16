void addEdge(int a, int b) {
    edge[a].add(b);
    edge[b].add(a);
}