int[] bfs(int n, int u, List<Integer>[] g) {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    int[] dist = new int[n];
    Arrays.fill(dist, n);
    dist[u] = 0;
    queue.add(u);
    while (!queue.isEmpty()) {
        u = queue.poll();
        for (int v : g[u]) {
            if (dist[v] == n) {
                dist[v] = dist[u] + 1;
                queue.add(v);
            }
        }
    }
    return dist;
}