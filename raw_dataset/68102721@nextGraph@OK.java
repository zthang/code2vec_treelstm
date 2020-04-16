ArrayList<Integer>[] nextGraph(int n, int m, boolean directed) throws IOException {
    ArrayList<Integer>[] graph = createGraph(n);
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1, u = in.nextInt() - 1;
        graph[v].add(u);
        if (!directed)
            graph[u].add(v);
    }
    return graph;
}