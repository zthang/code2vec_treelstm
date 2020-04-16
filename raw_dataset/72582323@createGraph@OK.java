ArrayList<Integer>[] createGraph(int n) {
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    return graph;
}