ArrayList<Integer>[] createGraph(int n) throws IOException {
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    return graph;
}