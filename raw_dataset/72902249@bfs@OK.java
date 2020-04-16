private void bfs() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(route[k - 1]);
    multiOptimal = new boolean[graph.size()];
    dist[route[k - 1]] = 0;
    while (queue.size() > 0) {
        int u = queue.pollFirst();
        for (int v : graph.get(u)) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                queue.add(v);
            } else if (dist[v] == dist[u] + 1) {
                multiOptimal[v] = true;
            }
        }
    }
}