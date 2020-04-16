static void bfs(int start) {
    dist = new int[N];
    Arrays.fill(dist, -1);
    multiOptimal = new boolean[N];
    Queue<Integer> q = new LinkedList<>();
    dist[start] = 0;
    q.add(start);
    while (!q.isEmpty()) {
        int cur = q.remove();
        for (int next : adjList[cur]) {
            if (dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.add(next);
            } else if (dist[next] == dist[cur] + 1) {
                multiOptimal[next] = true;
            }
        }
    }
}