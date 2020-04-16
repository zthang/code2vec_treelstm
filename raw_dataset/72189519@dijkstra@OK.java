public static int[] dijkstra(List<Edge>[] list, int V) {
    Queue<Edge> pq = new LinkedList<>();
    pq.offer(new Edge(V, 0));
    int[] d = new int[N + 1];
    Arrays.fill(d, INF);
    d[V] = 0;
    while (!pq.isEmpty()) {
        Edge e = pq.poll();
        if (d[e.to] < e.w) {
            continue;
        }
        for (Edge f : list[e.to]) {
            if (d[f.to] > d[e.to] + f.w) {
                d[f.to] = d[e.to] + f.w;
                pq.offer(new Edge(f.to, d[f.to]));
            }
        }
    }
    return d;
}