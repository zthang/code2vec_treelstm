graph getRev() {
    graph g = new graph(V);
    for (int i = 1; i <= V; i++) {
        for (int x : adjL[i]) {
            g.addEdge(x, i);
        }
    }
    return g;
}