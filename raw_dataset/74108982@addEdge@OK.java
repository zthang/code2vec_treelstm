public void addEdge(int s, int v) {
    list[s].add(v);
    list[v].add(s);
}