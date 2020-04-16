long[] calculateShortestPath(int source) {
    long[] dist = new long[node];
    PriorityQueue<Node> queue = new PriorityQueue<Main.Node>(new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            int val = Long.compare(o1.distance, o2.distance);
            return val;
        }
    });
    Arrays.fill(dist, INT_INF);
    queue.add(new Node(source, 0));
    dist[source] = 0;
    while (!queue.isEmpty()) {
        Node nn = queue.remove();
        int u = nn.node;
        long udist = nn.distance;
        if (udist > dist[u]) {
            continue;
        }
        for (Edge e : adj[u]) {
            int v = e.v;
            long vdist = e.cost;
            long arrive = udist + vdist;
            if (arrive < dist[v]) {
                dist[v] = arrive;
                queue.add(new Node(v, dist[v]));
            // System.out.println(u + " " + v + " " + vdist + " " + dist[v]);
            }
        }
    }
    return dist;
}