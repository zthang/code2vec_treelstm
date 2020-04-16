int calculateShortestPath(int source) {
    int[][] dist = new int[2][node];
    for (int i = 0; i < node; i++) {
        dist[0][i] = INT_INF;
        dist[1][i] = INT_INF;
    }
    dist[0][source] = 0;
    PriorityQueue<Node> queue = new PriorityQueue<Main.Node>(new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.operation == o2.operation) {
                if (o1.distance == o2.distance) {
                    return Integer.compare(o1.node, o2.node);
                }
                return Integer.compare(o1.distance, o2.distance);
            }
            return Integer.compare(o1.operation, o2.operation);
        }
    });
    queue.offer(new Node(0, source, 0));
    while (!queue.isEmpty()) {
        Node nn = queue.remove();
        int op = nn.operation;
        int u = nn.node;
        int d = nn.distance;
        if (u == node - 1 && op == 1) {
            return dist[1][u];
        }
        if (d > dist[op][u]) {
            continue;
        }
        for (Edge e : adj[u]) {
            int v = e.v;
            int w = e.cost;
            if (w + d < dist[0][v]) {
                dist[1][v] = dist[0][v];
                dist[0][v] = w + d;
                queue.add(new Node(1, v, dist[1][v]));
                queue.add(new Node(0, v, dist[0][v]));
            } else if (w + d > dist[0][v] && w + d < dist[1][v]) {
                dist[1][v] = w + d;
                queue.add(new Node(1, v, dist[1][v]));
            }
        }
    }
    return INT_INF;
}