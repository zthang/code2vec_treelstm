ArrayList<GraphPair>[] nextWeightedGraph(int n, int m, boolean directed) throws IOException {
    ArrayList<GraphPair>[] graph = createWeightedGraph(n);
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1, u = in.nextInt() - 1;
        long w = in.nextLong();
        graph[v].add(new GraphPair(u, w));
        if (!directed)
            graph[u].add(new GraphPair(v, w));
    }
    return graph;
}