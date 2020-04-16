public void addEdge(int u, int v) {
    if (!arr[u].contains(v)) {
        arr[u].add(v);
        arr[v].add(u);
    }
}