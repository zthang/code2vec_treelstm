// ----- Dijkstra ----- //
public void dijkstra(int src) {
    Queue<DijkstraState> pq = new PriorityQueue<>();
    pq.offer(new DijkstraState(src, 0));
    dist[src] = 0;
    while (!pq.isEmpty()) {
        DijkstraState cur = pq.poll();
        int u = cur.node;
        if (adj.containsKey(u)) {
            for (int next : adj.get(u).keySet()) {
                int v = next;
                int weight = adj.get(u).get(next);
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pv[v] = u;
                    pq.offer(new DijkstraState(v, dist[v]));
                }
            }
        }
    }
    return;
}