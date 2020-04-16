int[] dist(List<Integer>[] graph, int start) {
    int n = graph.length;
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    dist[start] = 0;
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int to : graph[cur]) {
            if (dist[to] == INF) {
                dist[to] = dist[cur] + 1;
                q.add(to);
            }
        }
    }
    return dist;
}