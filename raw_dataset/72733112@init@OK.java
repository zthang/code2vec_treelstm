static void init(int n) {
    V = n;
    graph = new ArrayList[V];
    graphT = new ArrayList[V];
    dist = new int[n];
    visited = new int[n];
    for (int i = 0; i < V; i++) {
        graph[i] = new ArrayList<>();
        graphT[i] = new ArrayList<>();
    }
}