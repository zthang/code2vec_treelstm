void addEdge(int s, int v) {
    ar[s].add(v);
    cr[v].add(s);
}