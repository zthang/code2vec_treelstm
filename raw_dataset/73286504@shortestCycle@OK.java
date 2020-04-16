static int shortestCycle(ArrayList<Integer>[] g, int n, int u0) {
    int[] p = new int[n];
    int[] dist = new int[n];
    Arrays.fill(p, -1);
    Arrays.fill(dist, -1);
    LinkedList<Integer> q = new LinkedList<>();
    q.add(u0);
    dist[u0] = 0;
    while (!q.isEmpty()) {
        int u = q.removeFirst();
        for (int v : g[u]) {
            if (dist[v] >= 0 && p[u] != v) {
                return dist[u] + dist[v] + 1;
            }
            if (dist[v] < 0) {
                p[v] = u;
                dist[v] = dist[u] + 1;
                q.add(v);
            }
        }
    }
    return n + 1;
}