int[] dist(int[][] g, int u) {
    int n = g.length;
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    dist[u] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
    pq.add(new int[] { u, 0 });
    while (!pq.isEmpty()) {
        int[] rv = pq.poll();
        u = rv[0];
        int d = rv[1];
        for (int v : g[u]) {
            if (dist[v] == -1 || 1 + d < dist[v]) {
                dist[v] = 1 + d;
                pq.add(new int[] { v, dist[v] });
            }
        }
    }
    return dist;
}