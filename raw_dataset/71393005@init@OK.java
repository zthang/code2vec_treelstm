static void init(int n) {
    V = n;
    graph = new ArrayList[V];
    for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
}