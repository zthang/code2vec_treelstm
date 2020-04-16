static void dijkstra() {
    boolean[] visited = new boolean[n];
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    for (int i = 0; i < k; i++) queue.add(new Edge(-1, i, 0));
    while (!queue.isEmpty()) {
        Edge curr = queue.poll();
        if (visited[curr.to])
            continue;
        visited[curr.to] = true;
        for (Edge e : adj[curr.to]) {
            if (visited[e.to])
                continue;
            if (minDist[e.to] > curr.weight + e.weight) {
                minDist[e.to] = curr.weight + e.weight;
                queue.add(new Edge(-1, e.to, minDist[e.to]));
            }
        }
    }
}