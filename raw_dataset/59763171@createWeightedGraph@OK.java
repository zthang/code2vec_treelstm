ArrayList<GraphPair>[] createWeightedGraph(int n) throws IOException {
    ArrayList<GraphPair>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    return graph;
}