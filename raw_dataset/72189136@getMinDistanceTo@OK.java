public int[] getMinDistanceTo(int v) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
    Node p = new Node(v, 0);
    boolean[] vis = new boolean[n + 1];
    int[] distance = new int[n + 1];
    vis[v] = true;
    pq.add(p);
    while (!pq.isEmpty()) {
        Node cur = pq.poll();
        distance[cur.u] = cur.distance;
        for (Edge e : adj[cur.u]) {
            if (!vis[e.v] && !e.enable) {
                vis[e.v] = true;
                pq.add(new Node(e.v, cur.distance + e.value));
            }
        }
    }
    return distance;
}