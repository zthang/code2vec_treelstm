private void run_case() {
    int n = scanner.nextInt(), m = scanner.nextInt();
    Graph dij = new Graph(n + 5);
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 0; i < m; i++) {
        int u = scanner.nextInt(), v = scanner.nextInt();
        adj.putIfAbsent(u, new HashSet<>());
        adj.get(u).add(v);
        dij.addEdge(v, u, 1);
    }
    int k = scanner.nextInt();
    int[] path = new int[k];
    for (int i = 0; i < k; i++) path[i] = scanner.nextInt();
    dij.dijkstra(path[k - 1]);
    int mi = 0, mx = 0;
    for (int i = 0; i + 1 < k; i++) {
        int u = path[i], v = path[i + 1], cnt = 0;
        if (adj.get(u) != null) {
            for (int nx : adj.get(u)) {
                if (dij.dist[nx] == dij.dist[u] - 1) {
                    cnt++;
                }
            }
        }
        if (dij.dist[v] != dij.dist[u] - 1) {
            mi++;
            mx++;
        } else {
            if (cnt > 1) {
                mx++;
            }
        }
    }
    System.out.println(mi + " " + mx);
    return;
}