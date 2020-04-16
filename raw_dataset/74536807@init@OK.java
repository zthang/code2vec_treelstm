static void init(int n) {
    V = n;
    log = (int) (Math.ceil(Math.log(n) / Math.log(2))) + 1;
    up = new int[n][log];
    lvl = new int[n];
    graph = new ArrayList[V];
    for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
}