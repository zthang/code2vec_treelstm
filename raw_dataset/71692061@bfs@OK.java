static int[] bfs(int s) {
    int[] dist = new int[adj.length];
    Arrays.fill(dist, -1);
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    dist[s] = 0;
    while (!q.isEmpty()) {
        int u = q.poll();
        for (int v : adj[u]) {
            if (dist[v] == -1) {
                q.add(v);
                dist[v] = dist[u] + 1;
            }
        }
    }
    return dist;
}